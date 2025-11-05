package com.discord.api.botuikit;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ButtonComponent.kt */
/* loaded from: classes.dex */
public final class ButtonStyleTypeAdapter extends TypeAdapter<ButtonStyle> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonStyle.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonStyle.PRIMARY.ordinal()] = 1;
            iArr[ButtonStyle.SECONDARY.ordinal()] = 2;
            iArr[ButtonStyle.SUCCESS.ordinal()] = 3;
            iArr[ButtonStyle.DANGER.ordinal()] = 4;
            iArr[ButtonStyle.LINK.ordinal()] = 5;
            iArr[ButtonStyle.UNKNOWN.ordinal()] = 6;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ButtonStyle read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? ButtonStyle.PRIMARY : (numN1 != null && numN1.intValue() == 2) ? ButtonStyle.SECONDARY : (numN1 != null && numN1.intValue() == 3) ? ButtonStyle.SUCCESS : (numN1 != null && numN1.intValue() == 4) ? ButtonStyle.DANGER : (numN1 != null && numN1.intValue() == 5) ? ButtonStyle.LINK : ButtonStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ButtonStyle buttonStyle) throws IOException {
        Integer num;
        ButtonStyle buttonStyle2 = buttonStyle;
        m.checkNotNullParameter(jsonWriter, "out");
        if (buttonStyle2 != null) {
            int iOrdinal = buttonStyle2.ordinal();
            if (iOrdinal == 0) {
                num = null;
            } else if (iOrdinal == 1) {
                num = 1;
            } else if (iOrdinal == 2) {
                num = 2;
            } else if (iOrdinal == 3) {
                num = 3;
            } else if (iOrdinal == 4) {
                num = 4;
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                num = 5;
            }
            jsonWriter.D(num);
        }
    }
}
