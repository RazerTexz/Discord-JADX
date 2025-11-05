package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* compiled from: ApplicationCommandPermission.kt */
/* loaded from: classes.dex */
public final class ApplicationCommandPermissionTypeTypeAdapter extends TypeAdapter<ApplicationCommandPermissionType> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandPermissionType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandPermissionType.ROLE.ordinal()] = 1;
            iArr[ApplicationCommandPermissionType.USER.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermissionType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        return iY != 1 ? iY != 2 ? ApplicationCommandPermissionType.UNKNOWN : ApplicationCommandPermissionType.USER : ApplicationCommandPermissionType.ROLE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JsonWriter jsonWriter, ApplicationCommandPermissionType applicationCommandPermissionType) throws IOException {
        ApplicationCommandPermissionType applicationCommandPermissionType2 = applicationCommandPermissionType;
        m.checkNotNullParameter(jsonWriter, "out");
        int i = 2;
        if (applicationCommandPermissionType2 != null) {
            int iOrdinal = applicationCommandPermissionType2.ordinal();
            if (iOrdinal == 1) {
                i = 1;
            } else if (iOrdinal != 2) {
                i = 0;
            }
        }
        jsonWriter.D(Integer.valueOf(i));
    }
}
