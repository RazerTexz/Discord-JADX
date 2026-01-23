package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.Component6;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ComponentTypeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<Component6> {
    @Override // com.google.gson.TypeAdapter
    public Component6 read(JsonReader jsonReader) throws IOException {
        Component6 component6;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = AnimatableValueParser.m549n1(jsonReader);
        Component6[] component6ArrValues = Component6.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                component6 = null;
                break;
            }
            component6 = component6ArrValues[i];
            if (numM549n1 != null && component6.getType() == numM549n1.intValue()) {
                break;
            }
            i++;
        }
        return component6 != null ? component6 : Component6.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Component6 component6) throws IOException {
        Component6 component62 = component6;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (component62 != null) {
            jsonWriter.mo6894D(Integer.valueOf(component62.getType()));
        }
    }
}
