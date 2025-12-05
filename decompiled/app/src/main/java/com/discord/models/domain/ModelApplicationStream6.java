package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: ModelApplicationStream.kt */
/* renamed from: com.discord.models.domain.StreamDelete$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelApplicationStream6<T> implements Action1<String> {
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $reasonStr;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $unavailable;

    public ModelApplicationStream6(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$reasonStr = ref$ObjectRef2;
        this.$unavailable = ref$ObjectRef3;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1194435296) {
                if (iHashCode != -934964668) {
                    if (iHashCode == -665462704 && str.equals("unavailable")) {
                        this.$unavailable.element = (T) this.$reader.nextBooleanOrNull();
                        return;
                    }
                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                    this.$reasonStr.element = (T) this.$reader.nextStringOrNull();
                    return;
                }
            } else if (str.equals("stream_key")) {
                Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                T t = (T) this.$reader.nextStringOrNull();
                Intrinsics3.checkNotNull(t);
                ref$ObjectRef.element = t;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
