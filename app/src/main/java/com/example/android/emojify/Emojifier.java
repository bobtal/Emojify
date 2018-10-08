package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

// COMPLETED (1): Create a Java class called Emojifier
public class Emojifier {
    private static final String TAG = Emojifier.class.getSimpleName();

    // COMPLETED (2): Create a static method in the Emojifier class called detectFaces()
    // which detects and logs the number of faces in a given bitmap.
    public static void detectFaces(Context context, Bitmap bitmap) {

        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        if (faces.size() > 0) {
            // Log the number of faces
            Log.d(TAG, "number of faces detected: " + faces.size());
        } else {
            // If there are no faces detected, show a Toast message
            Toast.makeText(context, "No faces detected in image", Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        detector.release();
    }
}
