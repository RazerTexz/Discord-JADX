package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.collection.ArrayMap;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3657f9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3730l0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3743m0;

/* JADX INFO: renamed from: b.i.a.f.i.b.fa */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4039fa extends AbstractC4027ea {

    /* JADX INFO: renamed from: g */
    public C3730l0 f10733g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C3991ba f10734h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4039fa(C3991ba c3991ba, String str, int i, C3730l0 c3730l0) {
        super(str, i);
        this.f10734h = c3991ba;
        this.f10733g = c3730l0;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: a */
    public final int mo5593a() {
        return this.f10733g.m5045y();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: g */
    public final boolean mo5594g() {
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: h */
    public final boolean mo5595h() {
        return this.f10733g.m5037C();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0190  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5602i(Long l, Long l2, C3579a1 c3579a1, long j, C4098l c4098l, boolean z2) {
        Boolean boolM5592f;
        Boolean boolM5590d;
        String string;
        boolean z3 = C3657f9.m4881b() && this.f10734h.f11202a.f11260h.m5532u(this.f10698a, C4142p.f11066c0);
        long j2 = this.f10733g.m5042H() ? c4098l.f10930e : j;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (this.f10734h.mo5726g().m5800x(2)) {
            this.f10734h.mo5726g().f11149n.m5863d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f10699b), this.f10733g.m5044x() ? Integer.valueOf(this.f10733g.m5045y()) : null, this.f10734h.m5865d().m5766u(this.f10733g.m5046z()));
            C4179s3 c4179s3 = this.f10734h.mo5726g().f11149n;
            C4163q9 c4163q9M5683m = this.f10734h.m5683m();
            C3730l0 c3730l0 = this.f10733g;
            Objects.requireNonNull(c4163q9M5683m);
            if (c3730l0 == null) {
                string = "null";
            } else {
                StringBuilder sbM833U = outline.m833U("\nevent_filter {\n");
                if (c3730l0.m5044x()) {
                    C4163q9.m5825L(sbM833U, 0, "filter_id", Integer.valueOf(c3730l0.m5045y()));
                }
                C4163q9.m5825L(sbM833U, 0, "event_name", c4163q9M5683m.m5865d().m5766u(c3730l0.m5046z()));
                String strM5818A = C4163q9.m5818A(c3730l0.m5039E(), c3730l0.m5040F(), c3730l0.m5042H());
                if (!strM5818A.isEmpty()) {
                    C4163q9.m5825L(sbM833U, 0, "filter_type", strM5818A);
                }
                if (c3730l0.m5037C()) {
                    C4163q9.m5823J(sbM833U, 1, "event_count_filter", c3730l0.m5038D());
                }
                if (c3730l0.m5036B() > 0) {
                    sbM833U.append("  filters {\n");
                    Iterator<C3743m0> it = c3730l0.m5035A().iterator();
                    while (it.hasNext()) {
                        c4163q9M5683m.m5836I(sbM833U, 2, it.next());
                    }
                }
                C4163q9.m5822H(sbM833U, 1);
                sbM833U.append("}\n}\n");
                string = sbM833U.toString();
            }
            c4179s3.m5861b("Filter definition", string);
        }
        if (!this.f10733g.m5044x() || this.f10733g.m5045y() > 256) {
            this.f10734h.mo5726g().f11144i.m5862c("Invalid event filter ID. appId, id", C4157q3.m5788s(this.f10698a), String.valueOf(this.f10733g.m5044x() ? Integer.valueOf(this.f10733g.m5045y()) : null));
            return false;
        }
        boolean z4 = this.f10733g.m5039E() || this.f10733g.m5040F() || this.f10733g.m5042H();
        if (z2 && !z4) {
            this.f10734h.mo5726g().f11149n.m5862c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f10699b), this.f10733g.m5044x() ? Integer.valueOf(this.f10733g.m5045y()) : null);
            return true;
        }
        C3730l0 c3730l02 = this.f10733g;
        String strM4533F = c3579a1.m4533F();
        if (!c3730l02.m5037C()) {
            HashSet hashSet = new HashSet();
            Iterator<C3743m0> it2 = c3730l02.m5035A().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator<C3607c1> it3 = c3579a1.m4543v().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            Iterator<C3743m0> it4 = c3730l02.m5035A().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                C3743m0 next = it4.next();
                                boolean z5 = next.m5069z() && next.m5062A();
                                String strM5064C = next.m5064C();
                                if (strM5064C.isEmpty()) {
                                    this.f10734h.mo5726g().f11144i.m5861b("Event has empty param name. event", this.f10734h.m5865d().m5766u(strM4533F));
                                    break;
                                }
                                Object obj = arrayMap.get(strM5064C);
                                if (obj instanceof Long) {
                                    if (!next.m5067x()) {
                                        this.f10734h.mo5726g().f11144i.m5862c("No number filter for long param. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                        break;
                                    }
                                    Boolean boolM5588b = AbstractC4027ea.m5588b(((Long) obj).longValue(), next.m5068y());
                                    if (boolM5588b == null) {
                                        break;
                                    }
                                    if (boolM5588b.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next.m5067x()) {
                                        this.f10734h.mo5726g().f11144i.m5862c("No number filter for double param. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                        break;
                                    }
                                    double dDoubleValue = ((Double) obj).doubleValue();
                                    try {
                                        boolM5592f = AbstractC4027ea.m5592f(new BigDecimal(dDoubleValue), next.m5068y(), Math.ulp(dDoubleValue));
                                    } catch (NumberFormatException unused) {
                                        boolM5592f = null;
                                    }
                                    if (boolM5592f == null) {
                                        break;
                                    }
                                    if (boolM5592f.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!next.m5065v()) {
                                        if (!next.m5067x()) {
                                            this.f10734h.mo5726g().f11144i.m5862c("No filter for String param. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!C4163q9.m5827P(str)) {
                                            this.f10734h.mo5726g().f11144i.m5862c("Invalid param value for number filter. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                            break;
                                        }
                                        boolM5590d = AbstractC4027ea.m5590d(str, next.m5068y());
                                    } else {
                                        boolM5590d = AbstractC4027ea.m5591e((String) obj, next.m5066w(), this.f10734h.mo5726g());
                                    }
                                    if (boolM5590d == null) {
                                        break;
                                    }
                                    if (boolM5590d.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.f10734h.mo5726g().f11149n.m5862c("Missing param for filter. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                    bool = Boolean.FALSE;
                                } else {
                                    this.f10734h.mo5726g().f11144i.m5862c("Unknown param type. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(strM5064C));
                                }
                            }
                        } else {
                            C3607c1 next2 = it3.next();
                            if (hashSet.contains(next2.m4587B())) {
                                if (!next2.m4590I()) {
                                    if (!next2.m4594M()) {
                                        if (!next2.m4588F()) {
                                            this.f10734h.mo5726g().f11144i.m5862c("Unknown value for param. event, param", this.f10734h.m5865d().m5766u(strM4533F), this.f10734h.m5865d().m5768x(next2.m4587B()));
                                            break;
                                        }
                                        arrayMap.put(next2.m4587B(), next2.m4589G());
                                    } else {
                                        arrayMap.put(next2.m4587B(), next2.m4594M() ? Double.valueOf(next2.m4595N()) : null);
                                    }
                                } else {
                                    arrayMap.put(next2.m4587B(), next2.m4590I() ? Long.valueOf(next2.m4591J()) : null);
                                }
                            }
                        }
                    }
                } else {
                    C3743m0 next3 = it2.next();
                    if (next3.m5064C().isEmpty()) {
                        this.f10734h.mo5726g().f11144i.m5861b("null or empty param name in filter. event", this.f10734h.m5865d().m5766u(strM4533F));
                        break;
                    }
                    hashSet.add(next3.m5064C());
                }
            }
        } else {
            Boolean boolM5588b2 = AbstractC4027ea.m5588b(j2, c3730l02.m5038D());
            if (boolM5588b2 != null) {
                if (!boolM5588b2.booleanValue()) {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.f10734h.mo5726g().f11149n.m5861b("Event filter result", bool != null ? bool : "null");
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.f10700c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.f10701d = bool2;
        if (z4 && c3579a1.m4534G()) {
            Long lValueOf = Long.valueOf(c3579a1.m4535H());
            if (this.f10733g.m5040F()) {
                if (z3 && this.f10733g.m5037C()) {
                    lValueOf = l;
                }
                this.f10703f = lValueOf;
            } else {
                if (z3 && this.f10733g.m5037C()) {
                    lValueOf = l2;
                }
                this.f10702e = lValueOf;
            }
        }
        return true;
    }
}
