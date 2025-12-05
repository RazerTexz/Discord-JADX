package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p463v.CameraOrchestrator;

/* compiled from: CameraStateOrchestrator.java */
/* renamed from: b.o.a.n.v.f, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraStateOrchestrator extends CameraOrchestrator {

    /* renamed from: f */
    public CameraState2 f14028f;

    /* renamed from: g */
    public CameraState2 f14029g;

    /* renamed from: h */
    public int f14030h;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: CameraStateOrchestrator.java */
    /* renamed from: b.o.a.n.v.f$a */
    public class a<T> implements InterfaceC4357c<T> {

        /* renamed from: a */
        public final /* synthetic */ int f14031a;

        public a(int i) {
            this.f14031a = i;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<T> task) {
            int i = this.f14031a;
            CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
            if (i == cameraStateOrchestrator.f14030h) {
                cameraStateOrchestrator.f14029g = cameraStateOrchestrator.f14028f;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: CameraStateOrchestrator.java */
    /* renamed from: b.o.a.n.v.f$b */
    public class b<T> implements Callable<Task<T>> {

        /* renamed from: j */
        public final /* synthetic */ CameraState2 f14033j;

        /* renamed from: k */
        public final /* synthetic */ String f14034k;

        /* renamed from: l */
        public final /* synthetic */ CameraState2 f14035l;

        /* renamed from: m */
        public final /* synthetic */ Callable f14036m;

        /* renamed from: n */
        public final /* synthetic */ boolean f14037n;

        public b(CameraState2 cameraState2, String str, CameraState2 cameraState22, Callable callable, boolean z2) {
            this.f14033j = cameraState2;
            this.f14034k = str;
            this.f14035l = cameraState22;
            this.f14036m = callable;
            this.f14037n = z2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
            if (cameraStateOrchestrator.f14028f == this.f14033j) {
                return ((Task) this.f14036m.call()).mo6015j(CameraEngine.this.f13919k.f14133g, new CameraStateOrchestrator2(this));
            }
            CameraOrchestrator.f14005a.m7159a(2, this.f14034k.toUpperCase(), "- State mismatch, aborting. current:", CameraStateOrchestrator.this.f14028f, "from:", this.f14033j, "to:", this.f14035l);
            C4358c0 c4358c0 = new C4358c0();
            c4358c0.m6026u();
            return c4358c0;
        }
    }

    public CameraStateOrchestrator(@NonNull CameraOrchestrator.b bVar) {
        super(bVar);
        CameraState2 cameraState2 = CameraState2.OFF;
        this.f14028f = cameraState2;
        this.f14029g = cameraState2;
        this.f14030h = 0;
    }

    @NonNull
    /* renamed from: f */
    public <T> Task<T> m7368f(@NonNull CameraState2 cameraState2, @NonNull CameraState2 cameraState22, boolean z2, @NonNull Callable<Task<T>> callable) {
        String str;
        int i = this.f14030h + 1;
        this.f14030h = i;
        this.f14029g = cameraState22;
        boolean z3 = !cameraState22.m7367f(cameraState2);
        if (z3) {
            str = cameraState2.name() + " << " + cameraState22.name();
        } else {
            str = cameraState2.name() + " >> " + cameraState22.name();
        }
        Task<T> taskM7365d = m7365d(str, z2, 0L, new b(cameraState2, str, cameraState22, callable, z3));
        taskM7365d.mo6007b(new a(i));
        return taskM7365d;
    }
}
