package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p401u.p402o.AutoValue_PersistedInstallationEntry;

/* JADX INFO: renamed from: b.i.c.u.o.c, reason: use source file name */
/* JADX INFO: compiled from: PersistedInstallation.java */
/* JADX INFO: loaded from: classes3.dex */
public class PersistedInstallation {

    /* JADX INFO: renamed from: a */
    public final File f12969a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FirebaseApp2 f12970b;

    /* JADX INFO: renamed from: b.i.c.u.o.c$a */
    /* JADX INFO: compiled from: PersistedInstallation.java */
    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(@NonNull FirebaseApp2 firebaseApp2) {
        firebaseApp2.m6330a();
        File filesDir = firebaseApp2.f12118d.getFilesDir();
        StringBuilder sbM833U = outline.m833U("PersistedInstallation.");
        sbM833U.append(firebaseApp2.m6331c());
        sbM833U.append(".json");
        this.f12969a = new File(filesDir, sbM833U.toString());
        this.f12970b = firebaseApp2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public PersistedInstallationEntry m6787a(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.mo6776c());
            jSONObject.put("Status", persistedInstallationEntry.mo6779f().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.mo6774a());
            jSONObject.put("RefreshToken", persistedInstallationEntry.mo6778e());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.mo6780g());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.mo6775b());
            jSONObject.put("FisError", persistedInstallationEntry.mo6777d());
            FirebaseApp2 firebaseApp2 = this.f12970b;
            firebaseApp2.m6330a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", firebaseApp2.f12118d.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Constants.ENCODING));
            fileOutputStream.close();
            if (!fileCreateTempFile.renameTo(this.f12969a)) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
        return persistedInstallationEntry;
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public PersistedInstallationEntry m6788b() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f12969a);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused2) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        a aVar = a.ATTEMPT_MIGRATION;
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = PersistedInstallationEntry.f12977a;
        AutoValue_PersistedInstallationEntry.b bVar = new AutoValue_PersistedInstallationEntry.b();
        bVar.m6785d(0L);
        bVar.mo6783b(aVar);
        bVar.m6784c(0L);
        bVar.f12959a = strOptString;
        bVar.mo6783b(a.values()[iOptInt]);
        bVar.f12961c = strOptString2;
        bVar.f12962d = strOptString3;
        bVar.m6785d(jOptLong);
        bVar.m6784c(jOptLong2);
        bVar.f12965g = strOptString4;
        return bVar.mo6782a();
    }
}
