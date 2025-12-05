package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.io.File;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: MetaDataStore.java */
/* renamed from: b.i.c.m.d.k.z0, reason: use source file name */
/* loaded from: classes3.dex */
public class MetaDataStore2 {

    /* renamed from: a */
    public static final Charset f12468a = Charset.forName(Constants.ENCODING);

    /* renamed from: b */
    public final File f12469b;

    public MetaDataStore2(File file) {
        this.f12469b = file;
    }

    /* renamed from: c */
    public static UserMetadata m6488c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        UserMetadata userMetadata = new UserMetadata();
        userMetadata.f12290a = UserMetadata.m6403b(jSONObject.isNull("userId") ? null : jSONObject.optString("userId", null));
        return userMetadata;
    }

    @NonNull
    /* renamed from: a */
    public File m6489a(String str) {
        return new File(this.f12469b, outline.m886y(str, "keys", ".meta"));
    }

    @NonNull
    /* renamed from: b */
    public File m6490b(String str) {
        return new File(this.f12469b, outline.m886y(str, "user", ".meta"));
    }
}
