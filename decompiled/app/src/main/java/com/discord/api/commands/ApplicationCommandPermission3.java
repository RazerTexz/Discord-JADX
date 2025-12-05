package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommandPermission.kt */
/* renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandPermission3 extends TypeAdapter<ApplicationCommandPermission2> {

    /* renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandPermission2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandPermission2.ROLE.ordinal()] = 1;
            iArr[ApplicationCommandPermission2.USER.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermission2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        return iMo6891y != 1 ? iMo6891y != 2 ? ApplicationCommandPermission2.UNKNOWN : ApplicationCommandPermission2.USER : ApplicationCommandPermission2.ROLE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JsonWriter jsonWriter, ApplicationCommandPermission2 applicationCommandPermission2) throws IOException {
        ApplicationCommandPermission2 applicationCommandPermission22 = applicationCommandPermission2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        int i = 2;
        if (applicationCommandPermission22 != null) {
            int iOrdinal = applicationCommandPermission22.ordinal();
            if (iOrdinal == 1) {
                i = 1;
            } else if (iOrdinal != 2) {
                i = 0;
            }
        }
        jsonWriter.mo6894D(Integer.valueOf(i));
    }
}
