package com.discord.api.botuikit.gson;

import b.c.a.a0.d;
import com.discord.api.botuikit.ComponentType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* compiled from: ComponentTypeTypeAdapter.kt */
/* loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<ComponentType> {
    @Override // com.google.gson.TypeAdapter
    public ComponentType read(JsonReader jsonReader) throws IOException {
        ComponentType componentType;
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        ComponentType[] componentTypeArrValues = ComponentType.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                componentType = null;
                break;
            }
            componentType = componentTypeArrValues[i];
            if (numN1 != null && componentType.getType() == numN1.intValue()) {
                break;
            }
            i++;
        }
        return componentType != null ? componentType : ComponentType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ComponentType componentType) throws IOException {
        ComponentType componentType2 = componentType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (componentType2 != null) {
            jsonWriter.D(Integer.valueOf(componentType2.getType()));
        }
    }
}
