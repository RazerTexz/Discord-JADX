package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p410q.JavaVersion;
import p007b.p225i.p408d.p410q.p411x.p412d.ISO8601Utils;

/* loaded from: classes3.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a */
    public static final TypeAdapterFactory2 f21516a = new C111071();

    /* renamed from: b */
    public final List<DateFormat> f21517b;

    /* renamed from: com.google.gson.internal.bind.DateTypeAdapter$1 */
    public class C111071 implements TypeAdapterFactory2 {
        @Override // p007b.p225i.p408d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    }

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f21517b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.f13123a >= 9) {
            arrayList.add(C3404f.m4336r0(2, 2));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        String strMo6877J = jsonReader.mo6877J();
        synchronized (this) {
            Iterator<DateFormat> it = this.f21517b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strMo6877J);
                } catch (ParseException unused) {
                }
            }
            try {
                return ISO8601Utils.m6910b(strMo6877J, new ParsePosition(0));
            } catch (ParseException e) {
                throw new JsonSyntaxException(strMo6877J, e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        synchronized (this) {
            if (date2 == null) {
                jsonWriter.mo6905s();
            } else {
                jsonWriter.mo6895H(this.f21517b.get(0).format(date2));
            }
        }
    }
}
