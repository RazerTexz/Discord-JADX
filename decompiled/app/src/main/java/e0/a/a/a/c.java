package e0.a.a.a;

import android.os.HandlerThread;

/* compiled from: CameraHandlerThread.java */
/* loaded from: classes3.dex */
public class c extends HandlerThread {
    public a j;

    public c(a aVar) {
        super("CameraHandlerThread");
        this.j = aVar;
        start();
    }
}
