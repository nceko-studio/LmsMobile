package com.example.lmspoltekgo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lmspoltekgo.api.ServerInterface;
import com.example.lmspoltekgo.api.ServerMoodle;
import com.example.lmspoltekgo.response.SubmitResponse;
import com.example.lmspoltekgo.response.UploadResponse;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitAssign extends AppCompatActivity {
    private static final int PICK_FILE_REQUEST_CODE = 1;
    int idFile;
    Button pilihFile, btnSubmit;
    String idBiodata, idTugas, token, username;
    private ServerInterface serverInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_assign);

        Intent intent = getIntent();
        idTugas = intent.getStringExtra("idtugas");
        idBiodata = intent.getStringExtra("idbiodata");
        token = intent.getStringExtra("token");
        username = intent.getStringExtra("username");

        pilihFile = findViewById(R.id.pilihFile);
        btnSubmit = findViewById(R.id.btnSubmit);

        pilihFile.setOnClickListener(view -> {
            getFileAndSend();
        });

        btnSubmit.setOnClickListener(view -> {
            if (idFile != 0) {
                sendSubmission(idFile, Integer.parseInt(idTugas));
            } else {
                Toast.makeText(this, "File belum diupload.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendSubmission(int kirimIdFile,int idTugas) {
        String ayotoken = token;
        String functiongo = "mod_assign_save_submission";
        String formatgo = "json";
        int file = kirimIdFile;
        int formagon = 1;
        String texas = "DONE";
        int idPunyaFIle = kirimIdFile;



        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        serverInterface.submitTugas(ayotoken,functiongo,formatgo,idTugas,texas, formagon,idPunyaFIle,file).enqueue(new Callback<List<SubmitResponse>>() {
            @Override
            public void onResponse(Call<List<SubmitResponse>> call, Response<List<SubmitResponse>> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Intent i = new Intent(SubmitAssign.this, Kursus.class);
                        startActivity(i);
                    } else if (response.body() instanceof List) {
                        List<SubmitResponse> submitResponses = (List<SubmitResponse>) response.body();

                        if (submitResponses.isEmpty()) {
                            // Respons berupa array kosong, tugas berhasil dikirim
                            Intent i = new Intent(SubmitAssign.this, Kursus.class);
                            i.putExtra("token",token);
                            i.putExtra("username",username);
                            startActivity(i);
                        } else {
                            // Respons berupa array, tetapi seharusnya kosong
                            Toast.makeText(SubmitAssign.this, "ERROR: Respons array tidak kosong", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Respons berupa objek, seperti yang diharapkan sebelumnya
                        Toast.makeText(SubmitAssign.this, "ERROR: Ada data di dalamnya", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Tangani respons gagal
                    Toast.makeText(SubmitAssign.this, "ERROR: Response tidak berhasil", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SubmitResponse>> call, Throwable t) {
                Toast.makeText(SubmitAssign.this, "ERROR : " +t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR : ", t.getMessage());
            }
        });

        }

    public void getFileAndSend(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri fileUri = data.getData();

            try {
                uploadFile(fileUri);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error uploading file: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadFile(Uri fileUri) throws FileNotFoundException {
        // Mendapatkan nama file dari URI
        String fileName = getFileNameFromUri(fileUri);

        // Membuat RequestBody untuk file
        RequestBody fileRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), getFileContent(fileUri));

        // Membuat MultipartBody.Part untuk mengirim file
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", fileName, fileRequestBody);

        // Membuat parameter lainnya
        Map<String, RequestBody> params = new HashMap<>();
        params.put("token", RequestBody.create(MediaType.parse("multipart/form-data"), token));
        params.put("function", RequestBody.create(MediaType.parse("multipart/form-data"), "core_files_upload"));
        params.put("moodlewsrestformat", RequestBody.create(MediaType.parse("multipart/form-data"), "json"));
        params.put("component", RequestBody.create(MediaType.parse("multipart/form-data"), "user"));
        params.put("filearea", RequestBody.create(MediaType.parse("multipart/form-data"), "draft"));
        params.put("itemid", RequestBody.create(MediaType.parse("multipart/form-data"), "0"));
        params.put("filepath", RequestBody.create(MediaType.parse("multipart/form-data"), "/"));
        params.put("contextlevel", RequestBody.create(MediaType.parse("multipart/form-data"), "user"));
        params.put("instanceid", RequestBody.create(MediaType.parse("multipart/form-data"), idBiodata));
        params.put("filename", RequestBody.create(MediaType.parse("multipart/form-data"), fileName));

        // Melakukan pengiriman ke server
        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        serverInterface.uploadFile(filePart,params).enqueue(new Callback<List<UploadResponse>>() {
            @Override
            public void onResponse(Call<List<UploadResponse>> call, Response<List<UploadResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<UploadResponse> uploadResponseList = response.body();

                    for (UploadResponse uploadResponse : uploadResponseList) {
                        long itemId = uploadResponse.getItemid();

                        idFile = Integer.parseInt(String.valueOf(itemId));

                        Log.d("source value", String.valueOf(itemId));

                        // Print the raw response for debugging
                        Log.d("raw response", response.raw().toString());
                    }
                } else {
                    // Debugging log
                    Log.d("Debug", "Response is not successful or body is null");

                    // Print the error body if available
                    try {
                        Log.d("error body", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UploadResponse>> call, Throwable t) {
                Toast.makeText(SubmitAssign.this, "ERROR : " +t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR : ", t.getMessage());
            }
        });
    }

    private String fileToBase64(Uri uri) {
        byte[] fileBytes;
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            fileBytes = new byte[inputStream.available()];
            inputStream.read(fileBytes);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.encodeToString(fileBytes, Base64.DEFAULT);
    }

    @SuppressLint("Range")
    private String getFileNameFromUri(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private byte[] getFileContent(Uri fileUri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(fileUri);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}