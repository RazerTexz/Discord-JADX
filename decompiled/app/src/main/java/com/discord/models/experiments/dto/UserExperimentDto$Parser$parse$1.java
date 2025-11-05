package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: UserExperimentDto.kt */
/* loaded from: classes.dex */
public final class UserExperimentDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $nameHash;
    public final /* synthetic */ Model.JsonReader $reader;

    public UserExperimentDto$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$nameHash = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$nameHash.element = this.$reader.nextLongOrNull();
    }
}
