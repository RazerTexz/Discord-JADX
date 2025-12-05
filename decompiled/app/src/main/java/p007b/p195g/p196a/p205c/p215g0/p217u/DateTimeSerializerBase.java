package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p219i0.StdDateFormat;
import p007b.p195g.p196a.p205c.p221z.BaseSettings;

/* compiled from: DateTimeSerializerBase.java */
/* renamed from: b.g.a.c.g0.u.l, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    public final DateFormat _customFormat;
    public final AtomicReference<DateFormat> _reusedCustomFormat;
    public final Boolean _useTimestamp;

    public DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TimeZone timeZoneM1602f;
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        if (dVarM2074l == null) {
            return this;
        }
        JsonFormat.c cVarM1601e = dVarM2074l.m1601e();
        if (cVarM1601e.m1596f()) {
            return mo2060r(Boolean.TRUE, null);
        }
        if (dVarM2074l.m1604h()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dVarM2074l.m1600d(), dVarM2074l.m1603g() ? dVarM2074l.m1599c() : serializerProvider._config._base._locale);
            if (dVarM2074l.m1606j()) {
                timeZoneM1602f = dVarM2074l.m1602f();
            } else {
                timeZoneM1602f = serializerProvider._config._base._timeZone;
                if (timeZoneM1602f == null) {
                    timeZoneM1602f = BaseSettings.f5074j;
                }
            }
            simpleDateFormat.setTimeZone(timeZoneM1602f);
            return mo2060r(Boolean.FALSE, simpleDateFormat);
        }
        boolean zM1603g = dVarM2074l.m1603g();
        boolean zM1606j = dVarM2074l.m1606j();
        boolean z2 = cVarM1601e == JsonFormat.c.STRING;
        if (!zM1603g && !zM1606j && !z2) {
            return this;
        }
        DateFormat dateFormat = serializerProvider._config._base._dateFormat;
        if (dateFormat instanceof StdDateFormat) {
            StdDateFormat stdDateFormatM2212m = (StdDateFormat) dateFormat;
            if (dVarM2074l.m1603g()) {
                stdDateFormatM2212m = stdDateFormatM2212m.m2211l(dVarM2074l.m1599c());
            }
            if (dVarM2074l.m1606j()) {
                stdDateFormatM2212m = stdDateFormatM2212m.m2212m(dVarM2074l.m1602f());
            }
            return mo2060r(Boolean.FALSE, stdDateFormatM2212m);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            serializerProvider.m1943g(this._handledType, String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
        SimpleDateFormat simpleDateFormat3 = zM1603g ? new SimpleDateFormat(simpleDateFormat2.toPattern(), dVarM2074l.m1599c()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone timeZoneM1602f2 = dVarM2074l.m1602f();
        if ((timeZoneM1602f2 == null || timeZoneM1602f2.equals(simpleDateFormat3.getTimeZone())) ? false : true) {
            simpleDateFormat3.setTimeZone(timeZoneM1602f2);
        }
        return mo2060r(Boolean.FALSE, simpleDateFormat3);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, T t) {
        return false;
    }

    /* renamed from: p */
    public boolean m2066p(SerializerProvider serializerProvider) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (serializerProvider != null) {
            return serializerProvider.m2240D(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        StringBuilder sbM833U = outline.m833U("Null SerializerProvider passed for ");
        sbM833U.append(this._handledType.getName());
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* renamed from: q */
    public void m2067q(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (this._customFormat == null) {
            Objects.requireNonNull(serializerProvider);
            if (serializerProvider.m2240D(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.mo1635I(date.getTime());
                return;
            } else {
                jsonGenerator.mo1658j0(serializerProvider.m2246j().format(date));
                return;
            }
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        jsonGenerator.mo1658j0(andSet.format(date));
        this._reusedCustomFormat.compareAndSet(null, andSet);
    }

    /* renamed from: r */
    public abstract DateTimeSerializerBase<T> mo2060r(Boolean bool, DateFormat dateFormat);
}
