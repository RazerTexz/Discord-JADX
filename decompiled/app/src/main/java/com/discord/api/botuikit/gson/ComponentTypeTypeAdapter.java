package com.discord.api.botuikit.gson;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.botuikit.Component6;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* compiled from: ComponentTypeTypeAdapter.kt */
/* loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<Component6> {
    @Override // com.google.gson.TypeAdapter
    public Component6 read(JsonReader jsonReader) throws IOException {
        Component6 component6;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Component6[] component6ArrValues = Component6.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                component6 = null;
                break;
            }
            component6 = component6ArrValues[i];
            if (numN1 != null && component6.getType() == numN1.intValue()) {
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
            jsonWriter.D(Integer.valueOf(component62.getType()));
        }
    }
}
