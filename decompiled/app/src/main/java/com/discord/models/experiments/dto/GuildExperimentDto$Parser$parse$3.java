package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$3 implements Runnable {
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $revision;

    public GuildExperimentDto$Parser$parse$3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$revision = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$revision.element = this.$jsonReader.nextIntOrNull();
    }
}
