package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $hashKey;
    public final /* synthetic */ Model.JsonReader $jsonReader;

    public GuildExperimentDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$hashKey = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$hashKey.element = this.$jsonReader.nextStringOrNull();
    }
}
