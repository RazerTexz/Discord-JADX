package p007b.p225i.p361c.p369m.p370d.p373k;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetaDataStore.java */
/* renamed from: b.i.c.m.d.k.y0, reason: use source file name */
/* loaded from: classes3.dex */
public class MetaDataStore extends JSONObject {

    /* renamed from: a */
    public final /* synthetic */ UserMetadata f12466a;

    public MetaDataStore(UserMetadata userMetadata) throws JSONException {
        this.f12466a = userMetadata;
        put("userId", userMetadata.f12290a);
    }
}
