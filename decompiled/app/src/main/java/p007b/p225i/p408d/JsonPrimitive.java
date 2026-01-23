package p007b.p225i.p408d;

import com.google.gson.JsonElement;
import java.math.BigInteger;
import java.util.Objects;
import p007b.p225i.p408d.p410q.LazilyParsedNumber;

/* JADX INFO: renamed from: b.i.d.k, reason: use source file name */
/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonPrimitive extends JsonElement {

    /* JADX INFO: renamed from: a */
    public final Object f13107a;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f13107a = bool;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m6857j(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.f13107a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: c */
    public int mo6854c() {
        return this.f13107a instanceof Number ? m6859i().intValue() : Integer.parseInt(mo6855g());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f13107a == null) {
            return jsonPrimitive.f13107a == null;
        }
        if (m6857j(this) && m6857j(jsonPrimitive)) {
            return m6859i().longValue() == jsonPrimitive.m6859i().longValue();
        }
        Object obj2 = this.f13107a;
        if (!(obj2 instanceof Number) || !(jsonPrimitive.f13107a instanceof Number)) {
            return obj2.equals(jsonPrimitive.f13107a);
        }
        double dDoubleValue = m6859i().doubleValue();
        double dDoubleValue2 = jsonPrimitive.m6859i().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: g */
    public String mo6855g() {
        Object obj = this.f13107a;
        return obj instanceof Number ? m6859i().toString() : obj instanceof Boolean ? ((Boolean) obj).toString() : (String) obj;
    }

    /* JADX INFO: renamed from: h */
    public boolean m6858h() {
        Object obj = this.f13107a;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(mo6855g());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f13107a == null) {
            return 31;
        }
        if (m6857j(this)) {
            jDoubleToLongBits = m6859i().longValue();
        } else {
            Object obj = this.f13107a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(m6859i().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    /* JADX INFO: renamed from: i */
    public Number m6859i() {
        Object obj = this.f13107a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.f13107a) : (Number) obj;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.f13107a = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.f13107a = str;
    }
}
