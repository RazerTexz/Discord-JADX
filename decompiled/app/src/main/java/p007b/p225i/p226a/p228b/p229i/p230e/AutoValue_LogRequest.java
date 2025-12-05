package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: AutoValue_LogRequest.java */
/* renamed from: b.i.a.b.i.e.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a */
    public final long f5181a;

    /* renamed from: b */
    public final long f5182b;

    /* renamed from: c */
    public final ClientInfo2 f5183c;

    /* renamed from: d */
    public final Integer f5184d;

    /* renamed from: e */
    public final String f5185e;

    /* renamed from: f */
    public final List<LogEvent> f5186f;

    /* renamed from: g */
    public final QosTier f5187g;

    public AutoValue_LogRequest(long j, long j2, ClientInfo2 clientInfo2, Integer num, String str, List list, QosTier qosTier, a aVar) {
        this.f5181a = j;
        this.f5182b = j2;
        this.f5183c = clientInfo2;
        this.f5184d = num;
        this.f5185e = str;
        this.f5186f = list;
        this.f5187g = qosTier;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    @Nullable
    /* renamed from: a */
    public ClientInfo2 mo2323a() {
        return this.f5183c;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    @Nullable
    /* renamed from: b */
    public List<LogEvent> mo2324b() {
        return this.f5186f;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    @Nullable
    /* renamed from: c */
    public Integer mo2325c() {
        return this.f5184d;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    @Nullable
    /* renamed from: d */
    public String mo2326d() {
        return this.f5185e;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    @Nullable
    /* renamed from: e */
    public QosTier mo2327e() {
        return this.f5187g;
    }

    public boolean equals(Object obj) {
        ClientInfo2 clientInfo2;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f5181a == logRequest.mo2328f() && this.f5182b == logRequest.mo2329g() && ((clientInfo2 = this.f5183c) != null ? clientInfo2.equals(logRequest.mo2323a()) : logRequest.mo2323a() == null) && ((num = this.f5184d) != null ? num.equals(logRequest.mo2325c()) : logRequest.mo2325c() == null) && ((str = this.f5185e) != null ? str.equals(logRequest.mo2326d()) : logRequest.mo2326d() == null) && ((list = this.f5186f) != null ? list.equals(logRequest.mo2324b()) : logRequest.mo2324b() == null)) {
            QosTier qosTier = this.f5187g;
            if (qosTier == null) {
                if (logRequest.mo2327e() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.mo2327e())) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    /* renamed from: f */
    public long mo2328f() {
        return this.f5181a;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.LogRequest
    /* renamed from: g */
    public long mo2329g() {
        return this.f5182b;
    }

    public int hashCode() {
        long j = this.f5181a;
        long j2 = this.f5182b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        ClientInfo2 clientInfo2 = this.f5183c;
        int iHashCode = (i ^ (clientInfo2 == null ? 0 : clientInfo2.hashCode())) * 1000003;
        Integer num = this.f5184d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f5185e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.f5186f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f5187g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("LogRequest{requestTimeMs=");
        sbM833U.append(this.f5181a);
        sbM833U.append(", requestUptimeMs=");
        sbM833U.append(this.f5182b);
        sbM833U.append(", clientInfo=");
        sbM833U.append(this.f5183c);
        sbM833U.append(", logSource=");
        sbM833U.append(this.f5184d);
        sbM833U.append(", logSourceName=");
        sbM833U.append(this.f5185e);
        sbM833U.append(", logEvents=");
        sbM833U.append(this.f5186f);
        sbM833U.append(", qosTier=");
        sbM833U.append(this.f5187g);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
