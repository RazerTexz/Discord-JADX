package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: renamed from: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$4, reason: use source file name */
/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserExperimentDto5 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $population;
    public final /* synthetic */ Model.JsonReader $reader;

    public UserExperimentDto5(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$population = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$population.element = this.$reader.nextIntOrNull();
    }
}
