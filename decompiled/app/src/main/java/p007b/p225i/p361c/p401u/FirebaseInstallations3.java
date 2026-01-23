package p007b.p225i.p361c.p401u;

import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.util.Objects;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p401u.p402o.AutoValue_PersistedInstallationEntry;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallation;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;

/* JADX INFO: renamed from: b.i.c.u.e, reason: use source file name */
/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class FirebaseInstallations3 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final FirebaseInstallations4 f12926j;

    /* JADX INFO: renamed from: k */
    public final boolean f12927k;

    public FirebaseInstallations3(FirebaseInstallations4 firebaseInstallations4, boolean z2) {
        this.f12926j = firebaseInstallations4;
        this.f12927k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        CrossProcessLock crossProcessLockM6753a;
        PersistedInstallationEntry persistedInstallationEntryM6788b;
        PersistedInstallationEntry persistedInstallationEntryM6764j;
        FirebaseInstallations4 firebaseInstallations4 = this.f12926j;
        boolean z2 = this.f12927k;
        Object obj = FirebaseInstallations4.f12928a;
        Objects.requireNonNull(firebaseInstallations4);
        Object obj2 = FirebaseInstallations4.f12928a;
        synchronized (obj2) {
            FirebaseApp2 firebaseApp2 = firebaseInstallations4.f12930c;
            firebaseApp2.m6330a();
            crossProcessLockM6753a = CrossProcessLock.m6753a(firebaseApp2.f12118d, "generatefid.lock");
            try {
                persistedInstallationEntryM6788b = firebaseInstallations4.f12932e.m6788b();
            } finally {
                if (crossProcessLockM6753a != null) {
                    crossProcessLockM6753a.m6754b();
                }
            }
        }
        try {
            if (persistedInstallationEntryM6788b.m6789h()) {
                persistedInstallationEntryM6764j = firebaseInstallations4.m6764j(persistedInstallationEntryM6788b);
            } else {
                if (persistedInstallationEntryM6788b.mo6779f() == PersistedInstallation.a.UNREGISTERED) {
                    persistedInstallationEntryM6764j = firebaseInstallations4.m6764j(persistedInstallationEntryM6788b);
                } else if (!z2 && !firebaseInstallations4.f12933f.m6773d(persistedInstallationEntryM6788b)) {
                    return;
                } else {
                    persistedInstallationEntryM6764j = firebaseInstallations4.m6758c(persistedInstallationEntryM6788b);
                }
            }
            synchronized (obj2) {
                FirebaseApp2 firebaseApp22 = firebaseInstallations4.f12930c;
                firebaseApp22.m6330a();
                crossProcessLockM6753a = CrossProcessLock.m6753a(firebaseApp22.f12118d, "generatefid.lock");
                try {
                    firebaseInstallations4.f12932e.m6787a(persistedInstallationEntryM6764j);
                    if (crossProcessLockM6753a != null) {
                        crossProcessLockM6753a.m6754b();
                    }
                } finally {
                    if (crossProcessLockM6753a != null) {
                        crossProcessLockM6753a.m6754b();
                    }
                }
            }
            if (persistedInstallationEntryM6764j.m6791j()) {
                String str = ((AutoValue_PersistedInstallationEntry) persistedInstallationEntryM6764j).f12952b;
                synchronized (firebaseInstallations4) {
                    firebaseInstallations4.f12939l = str;
                }
            }
            if (persistedInstallationEntryM6764j.m6789h()) {
                firebaseInstallations4.m6765k(new FirebaseInstallationsException(FirebaseInstallationsException.EnumC11081a.BAD_CONFIG));
            } else if (persistedInstallationEntryM6764j.m6790i()) {
                firebaseInstallations4.m6765k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                firebaseInstallations4.m6766l(persistedInstallationEntryM6764j);
            }
        } catch (FirebaseInstallationsException e) {
            firebaseInstallations4.m6765k(e);
        }
    }
}
