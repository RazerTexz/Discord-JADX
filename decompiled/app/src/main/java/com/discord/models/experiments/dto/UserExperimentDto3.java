package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: renamed from: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$2, reason: use source file name */
/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserExperimentDto3 implements Runnable {
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $revision;

    public UserExperimentDto3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$revision = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$revision.element = this.$reader.nextIntOrNull();
    }
}
