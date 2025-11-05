package com.discord.api.botuikit;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TextComponent.kt */
/* loaded from: classes.dex */
public final class TextStyleTypeAdapter extends TypeAdapter<TextStyle> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TextStyle.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextStyle.SMALL.ordinal()] = 1;
            iArr[TextStyle.PARAGRAPH.ordinal()] = 2;
            iArr[TextStyle.UNKNOWN.ordinal()] = 3;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public TextStyle read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? TextStyle.SMALL : (numN1 != null && numN1.intValue() == 2) ? TextStyle.PARAGRAPH : TextStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TextStyle textStyle) throws IOException {
        Integer num;
        TextStyle textStyle2 = textStyle;
        m.checkNotNullParameter(jsonWriter, "out");
        if (textStyle2 != null) {
            int iOrdinal = textStyle2.ordinal();
            if (iOrdinal == 0) {
                num = 1;
            } else if (iOrdinal == 1) {
                num = 2;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                num = null;
            }
            jsonWriter.D(num);
        }
    }
}
