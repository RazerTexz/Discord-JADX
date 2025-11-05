package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: UserExperimentDto.kt */
/* renamed from: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$3, reason: use source file name */
/* loaded from: classes.dex */
public final class UserExperimentDto4 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $bucket;
    public final /* synthetic */ Model.JsonReader $reader;

    public UserExperimentDto4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$bucket = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$bucket.element = this.$reader.nextIntOrNull();
    }
}
