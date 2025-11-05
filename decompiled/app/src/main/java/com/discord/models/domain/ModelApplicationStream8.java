package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelApplicationStream.kt */
/* renamed from: com.discord.models.domain.StreamServerUpdate$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelApplicationStream8<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $endpoint;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $token;

    public ModelApplicationStream8(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$endpoint = ref$ObjectRef2;
        this.$token = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1194435296) {
                if (iHashCode != 110541305) {
                    if (iHashCode == 1741102485 && str.equals("endpoint")) {
                        this.$endpoint.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                } else if (str.equals("token")) {
                    this.$token.element = (T) this.$reader.nextStringOrNull();
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
