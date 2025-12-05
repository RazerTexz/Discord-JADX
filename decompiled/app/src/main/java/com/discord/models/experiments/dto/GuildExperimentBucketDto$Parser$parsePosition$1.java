package com.discord.models.experiments.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import p658rx.functions.Action1;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parsePosition$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $end;
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$IntRef $start;

    public GuildExperimentBucketDto$Parser$parsePosition$1(Ref$IntRef ref$IntRef, Model.JsonReader jsonReader, Ref$IntRef ref$IntRef2) {
        this.$start = ref$IntRef;
        this.$jsonReader = jsonReader;
        this.$end = ref$IntRef2;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 101) {
                if (iHashCode == 115 && str.equals("s")) {
                    Ref$IntRef ref$IntRef = this.$start;
                    ref$IntRef.element = this.$jsonReader.nextInt(ref$IntRef.element);
                    return;
                }
            } else if (str.equals("e")) {
                Ref$IntRef ref$IntRef2 = this.$end;
                ref$IntRef2.element = this.$jsonReader.nextInt(ref$IntRef2.element);
                return;
            }
        }
        this.$jsonReader.skipValue();
    }
}
