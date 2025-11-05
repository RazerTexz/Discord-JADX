package b.f.d.m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;

/* compiled from: WebpBitmapFactory.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: WebpBitmapFactory.java */
    public interface a {
        void a(String str, String str2);
    }

    Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);
}
