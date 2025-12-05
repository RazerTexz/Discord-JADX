package p007b.p225i.p226a.p242c.p266w2;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;
import p007b.p225i.p226a.p242c.p267x2.p274i0.PsshAtomUtil;
import p007b.p225i.p355b.p356a.Charsets;

/* compiled from: FrameworkMediaDrm.java */
@RequiresApi(18)
/* renamed from: b.i.a.c.w2.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* renamed from: a */
    public static final /* synthetic */ int f7977a = 0;

    /* renamed from: b */
    public final UUID f7978b;

    /* renamed from: c */
    public final MediaDrm f7979c;

    /* renamed from: d */
    public int f7980d;

    /* compiled from: FrameworkMediaDrm.java */
    @RequiresApi(31)
    /* renamed from: b.i.a.c.w2.c0$a */
    public static class a {
        @DoNotInline
        /* renamed from: a */
        public static boolean m3582a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    public FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Objects.requireNonNull(uuid);
        UUID uuid2 = C.f8022b;
        AnimatableValueParser.m543m(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f7978b = uuid;
        MediaDrm mediaDrm = new MediaDrm((Util2.f6708a >= 27 || !C.f8023c.equals(uuid)) ? uuid : uuid2);
        this.f7979c = mediaDrm;
        this.f7980d = 1;
        if (C.f8024d.equals(uuid) && "ASUS_Z00AD".equals(Util2.f6711d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: a */
    public Map<String, String> mo3569a(byte[] bArr) {
        return this.f7979c.queryKeyStatus(bArr);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: b */
    public ExoMediaDrm.d mo3570b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f7979c.getProvisionRequest();
        return new ExoMediaDrm.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: c */
    public CryptoConfig mo3571c(byte[] bArr) throws MediaCryptoException {
        int i = Util2.f6708a;
        boolean z2 = i < 21 && C.f8024d.equals(this.f7978b) && "L3".equals(this.f7979c.getPropertyString("securityLevel"));
        UUID uuid = this.f7978b;
        if (i < 27 && C.f8023c.equals(uuid)) {
            uuid = C.f8022b;
        }
        return new FrameworkCryptoConfig(uuid, bArr, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: d */
    public byte[] mo3572d() throws MediaDrmException {
        return this.f7979c.openSession();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: e */
    public boolean mo3573e(byte[] bArr, String str) {
        if (Util2.f6708a >= 31) {
            return a.m3582a(this.f7979c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f7978b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: f */
    public void mo3574f(byte[] bArr, byte[] bArr2) {
        this.f7979c.restoreKeys(bArr, bArr2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: g */
    public void mo3575g(byte[] bArr) {
        this.f7979c.closeSession(bArr);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: h */
    public void mo3576h(@Nullable ExoMediaDrm.b bVar) {
        this.f7979c.setOnEventListener(new C2984o(this, bVar));
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    @Nullable
    /* renamed from: i */
    public byte[] mo3577i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (C.f8023c.equals(this.f7978b) && Util2.f6708a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util2.m3004l(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', MentionUtils.SLASH_CHAR));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = Util2.m3015w(sb.toString());
            } catch (JSONException e) {
                String strM3004l = Util2.m3004l(bArr2);
                Log2.m3039b("ClearKeyUtil", strM3004l.length() != 0 ? "Failed to adjust response data: ".concat(strM3004l) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.f7979c.provideKeyResponse(bArr, bArr2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: j */
    public void mo3578j(byte[] bArr) throws DeniedByServerException {
        this.f7979c.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0206  */
    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    @SuppressLint({"WrongConstant"})
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExoMediaDrm.a mo3579k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        DrmInitData.SchemeData schemeData;
        boolean z2;
        byte[] bArrM585w1;
        DrmInitData.SchemeData schemeData2 = null;
        if (list != null) {
            if (!C.f8024d.equals(this.f7978b)) {
                schemeData = list.get(0);
            } else if (Util2.f6708a < 28 || list.size() <= 1) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    DrmInitData.SchemeData schemeData3 = list.get(i2);
                    byte[] bArr3 = schemeData3.f19855n;
                    Objects.requireNonNull(bArr3);
                    PsshAtomUtil psshAtomUtilM581v1 = AnimatableValueParser.m581v1(bArr3);
                    int i3 = psshAtomUtilM581v1 == null ? -1 : psshAtomUtilM581v1.f8450b;
                    int i4 = Util2.f6708a;
                    if ((i4 < 23 && i3 == 0) || (i4 >= 23 && i3 == 1)) {
                        schemeData2 = schemeData3;
                        break;
                    }
                }
                schemeData = list.get(0);
            } else {
                DrmInitData.SchemeData schemeData4 = list.get(0);
                int length = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    DrmInitData.SchemeData schemeData5 = list.get(i5);
                    byte[] bArr4 = schemeData5.f19855n;
                    Objects.requireNonNull(bArr4);
                    if (Util2.m2993a(schemeData5.f19854m, schemeData4.f19854m) && Util2.m2993a(schemeData5.f19853l, schemeData4.f19853l)) {
                        if (AnimatableValueParser.m581v1(bArr4) != null) {
                            length += bArr4.length;
                        }
                    }
                    z2 = false;
                }
                z2 = true;
                if (z2) {
                    byte[] bArr5 = new byte[length];
                    int i6 = 0;
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        byte[] bArr6 = list.get(i7).f19855n;
                        Objects.requireNonNull(bArr6);
                        int length2 = bArr6.length;
                        System.arraycopy(bArr6, 0, bArr5, i6, length2);
                        i6 += length2;
                    }
                    schemeData = new DrmInitData.SchemeData(schemeData4.f19852k, schemeData4.f19853l, schemeData4.f19854m, bArr5);
                }
            }
            schemeData2 = schemeData;
            UUID uuid = this.f7978b;
            byte[] bArrArray = schemeData2.f19855n;
            Objects.requireNonNull(bArrArray);
            UUID uuid2 = C.f8025e;
            if (uuid2.equals(uuid)) {
                byte[] bArrM585w12 = AnimatableValueParser.m585w1(bArrArray, uuid);
                if (bArrM585w12 != null) {
                    bArrArray = bArrM585w12;
                }
                int i8 = (bArrArray[0] & 255) | ((bArrArray[1] & 255) << 8) | ((bArrArray[2] & 255) << 16) | ((bArrArray[3] & 255) << 24);
                short s2 = (short) (((bArrArray[5] & 255) << 8) | (bArrArray[4] & 255));
                short s3 = (short) (((bArrArray[7] & 255) << 8) | (bArrArray[6] & 255));
                if (s2 == 1 && s3 == 1) {
                    short s4 = (short) (((bArrArray[9] & 255) << 8) | (bArrArray[8] & 255));
                    Charset charset = Charsets.f11946d;
                    String str2 = new String(bArrArray, 10, s4, charset);
                    if (!str2.contains("<LA_URL>")) {
                        int iIndexOf = str2.indexOf("</DATA>");
                        if (iIndexOf == -1) {
                            Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String strSubstring = str2.substring(0, iIndexOf);
                        String strSubstring2 = str2.substring(iIndexOf);
                        String strM859k = outline.m859k(outline.m841b(strSubstring2, outline.m841b(strSubstring, 26)), strSubstring, "<LA_URL>https://x</LA_URL>", strSubstring2);
                        int i9 = i8 + 52;
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i9);
                        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                        byteBufferAllocate.putInt(i9);
                        byteBufferAllocate.putShort(s2);
                        byteBufferAllocate.putShort(s3);
                        byteBufferAllocate.putShort((short) (strM859k.length() * 2));
                        byteBufferAllocate.put(strM859k.getBytes(charset));
                        bArrArray = byteBufferAllocate.array();
                    }
                } else {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                int length3 = (bArrArray != null ? bArrArray.length : 0) + 32;
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(length3);
                byteBufferAllocate2.putInt(length3);
                byteBufferAllocate2.putInt(1886614376);
                byteBufferAllocate2.putInt(0);
                byteBufferAllocate2.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate2.putLong(uuid2.getLeastSignificantBits());
                if (bArrArray != null && bArrArray.length != 0) {
                    byteBufferAllocate2.putInt(bArrArray.length);
                    byteBufferAllocate2.put(bArrArray);
                }
                bArrArray = byteBufferAllocate2.array();
            }
            int i10 = Util2.f6708a;
            if (i10 >= 23 || !C.f8024d.equals(uuid)) {
                if (uuid2.equals(uuid) && "Amazon".equals(Util2.f6710c)) {
                    String str3 = Util2.f6711d;
                    if ("AFTB".equals(str3) || "AFTS".equals(str3) || "AFTM".equals(str3) || "AFTT".equals(str3)) {
                        bArrM585w1 = AnimatableValueParser.m585w1(bArrArray, uuid);
                        if (bArrM585w1 == null) {
                        }
                        UUID uuid3 = this.f7978b;
                        String str4 = schemeData2.f19854m;
                        bArr2 = bArrM585w1;
                        str = (i10 >= 26 && C.f8023c.equals(uuid3) && ("video/mp4".equals(str4) || "audio/mp4".equals(str4))) ? "cenc" : str4;
                    }
                }
                bArrM585w1 = bArrArray;
                UUID uuid32 = this.f7978b;
                String str42 = schemeData2.f19854m;
                if (i10 >= 26) {
                    bArr2 = bArrM585w1;
                    str = (i10 >= 26 && C.f8023c.equals(uuid32) && ("video/mp4".equals(str42) || "audio/mp4".equals(str42))) ? "cenc" : str42;
                }
            }
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f7979c.getKeyRequest(bArr, bArr2, str, i, map);
        UUID uuid4 = this.f7978b;
        byte[] data = keyRequest.getData();
        if (C.f8023c.equals(uuid4) && Util2.f6708a < 27) {
            data = Util2.m3015w(Util2.m3004l(data).replace('+', '-').replace(MentionUtils.SLASH_CHAR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData2 != null && !TextUtils.isEmpty(schemeData2.f19853l)) {
            defaultUrl = schemeData2.f19853l;
        }
        return new ExoMediaDrm.a(data, defaultUrl, Util2.f6708a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: l */
    public int mo3580l() {
        return 2;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    public synchronized void release() {
        int i = this.f7980d - 1;
        this.f7980d = i;
        if (i == 0) {
            this.f7979c.release();
        }
    }
}
