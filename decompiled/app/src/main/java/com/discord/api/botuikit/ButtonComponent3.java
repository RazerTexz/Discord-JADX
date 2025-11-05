package com.discord.api.botuikit;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ButtonComponent.kt */
/* renamed from: com.discord.api.botuikit.ButtonStyleTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ButtonComponent3 extends TypeAdapter<ButtonComponent2> {

    /* renamed from: com.discord.api.botuikit.ButtonStyleTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonComponent2.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonComponent2.PRIMARY.ordinal()] = 1;
            iArr[ButtonComponent2.SECONDARY.ordinal()] = 2;
            iArr[ButtonComponent2.SUCCESS.ordinal()] = 3;
            iArr[ButtonComponent2.DANGER.ordinal()] = 4;
            iArr[ButtonComponent2.LINK.ordinal()] = 5;
            iArr[ButtonComponent2.UNKNOWN.ordinal()] = 6;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ButtonComponent2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? ButtonComponent2.PRIMARY : (numN1 != null && numN1.intValue() == 2) ? ButtonComponent2.SECONDARY : (numN1 != null && numN1.intValue() == 3) ? ButtonComponent2.SUCCESS : (numN1 != null && numN1.intValue() == 4) ? ButtonComponent2.DANGER : (numN1 != null && numN1.intValue() == 5) ? ButtonComponent2.LINK : ButtonComponent2.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ButtonComponent2 buttonComponent2) throws IOException {
        Integer num;
        ButtonComponent2 buttonComponent22 = buttonComponent2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (buttonComponent22 != null) {
            int iOrdinal = buttonComponent22.ordinal();
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
