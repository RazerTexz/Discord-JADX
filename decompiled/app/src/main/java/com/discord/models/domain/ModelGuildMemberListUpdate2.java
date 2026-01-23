package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Group$Parser$parse$1, reason: use source file name */
/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate2<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $count;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelGuildMemberListUpdate2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$IntRef ref$IntRef) {
        this.$id = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$count = ref$IntRef;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 3355) {
                if (iHashCode == 94851343 && str.equals("count")) {
                    Ref$IntRef ref$IntRef = this.$count;
                    Integer numNextIntOrNull = this.$reader.nextIntOrNull();
                    Intrinsics3.checkNotNullExpressionValue(numNextIntOrNull, "reader.nextIntOrNull()");
                    ref$IntRef.element = numNextIntOrNull.intValue();
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                Ref$ObjectRef ref$ObjectRef = this.$id;
                T t = (T) this.$reader.nextString("");
                Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                ref$ObjectRef.element = t;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
