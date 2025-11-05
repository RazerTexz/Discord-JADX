package b.i.c.u;

import b.i.c.u.o.c;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FirebaseInstallations.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final f j;
    public final boolean k;

    public e(f fVar, boolean z2) {
        this.j = fVar;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVarA;
        b.i.c.u.o.d dVarB;
        b.i.c.u.o.d dVarJ;
        f fVar = this.j;
        boolean z2 = this.k;
        Object obj = f.a;
        Objects.requireNonNull(fVar);
        Object obj2 = f.a;
        synchronized (obj2) {
            b.i.c.c cVar = fVar.c;
            cVar.a();
            bVarA = b.a(cVar.d, "generatefid.lock");
            try {
                dVarB = fVar.e.b();
            } finally {
                if (bVarA != null) {
                    bVarA.b();
                }
            }
        }
        try {
            if (dVarB.h()) {
                dVarJ = fVar.j(dVarB);
            } else {
                if (dVarB.f() == c.a.UNREGISTERED) {
                    dVarJ = fVar.j(dVarB);
                } else if (!z2 && !fVar.f.d(dVarB)) {
                    return;
                } else {
                    dVarJ = fVar.c(dVarB);
                }
            }
            synchronized (obj2) {
                b.i.c.c cVar2 = fVar.c;
                cVar2.a();
                bVarA = b.a(cVar2.d, "generatefid.lock");
                try {
                    fVar.e.a(dVarJ);
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } finally {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                }
            }
            if (dVarJ.j()) {
                String str = ((b.i.c.u.o.a) dVarJ).f1784b;
                synchronized (fVar) {
                    fVar.l = str;
                }
            }
            if (dVarJ.h()) {
                fVar.k(new FirebaseInstallationsException(FirebaseInstallationsException.a.BAD_CONFIG));
            } else if (dVarJ.i()) {
                fVar.k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                fVar.l(dVarJ);
            }
        } catch (FirebaseInstallationsException e) {
            fVar.k(e);
        }
    }
}
