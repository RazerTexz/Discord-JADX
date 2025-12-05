package com.discord.api.user;

import com.discord.api.user.Phone;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Phone.kt */
/* renamed from: com.discord.api.user.PhoneTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class Phone2 extends TypeAdapter<Phone> {
    @Override // com.google.gson.TypeAdapter
    public Phone read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return Phone.NoPhoneNumber.INSTANCE;
        }
        String strMo6877J = jsonReader.mo6877J();
        Intrinsics3.checkNotNullExpressionValue(strMo6877J, "number");
        return new Phone.PhoneNumber(strMo6877J);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Phone phone) throws IOException {
        JsonWriter jsonWriterMo6905s;
        Phone phone2 = phone;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (phone2 instanceof Phone.PhoneNumber) {
            jsonWriterMo6905s = jsonWriter.mo6895H(((Phone.PhoneNumber) phone2).getNumber());
        } else {
            if (!Intrinsics3.areEqual(phone2, Phone.NoPhoneNumber.INSTANCE) && phone2 != null) {
                throw new NoWhenBranchMatchedException();
            }
            jsonWriterMo6905s = jsonWriter.mo6905s();
        }
        jsonWriterMo6905s.getClass();
    }
}
