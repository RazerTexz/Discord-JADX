package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationStream4<T> implements Action1<String> {
    public final /* synthetic */ Ref$BooleanRef $paused;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $rtcServerId;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $viewerIds;

    /* JADX INFO: renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1$1 */
    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class C55431<T> implements Model.JsonReader.ItemFactory<Long> {
        public C55431() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Long get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Long get() {
            return Long.valueOf(ModelApplicationStream4.this.$reader.nextLong(0L));
        }
    }

    public ModelApplicationStream4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$rtcServerId = ref$ObjectRef2;
        this.$paused = ref$BooleanRef;
        this.$viewerIds = ref$ObjectRef3;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1349214453:
                    if (str.equals("viewer_ids")) {
                        this.$viewerIds.element = (T) this.$reader.nextList(new C55431());
                        return;
                    }
                    break;
                case -1194435296:
                    if (str.equals("stream_key")) {
                        Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                        T t = (T) this.$reader.nextStringOrNull();
                        Intrinsics3.checkNotNull(t);
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        Ref$BooleanRef ref$BooleanRef = this.$paused;
                        Boolean boolNextBooleanOrNull = this.$reader.nextBooleanOrNull();
                        Intrinsics3.checkNotNullExpressionValue(boolNextBooleanOrNull, "reader.nextBooleanOrNull()");
                        ref$BooleanRef.element = boolNextBooleanOrNull.booleanValue();
                        return;
                    }
                    break;
                case -490387655:
                    if (str.equals("rtc_server_id")) {
                        this.$rtcServerId.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
