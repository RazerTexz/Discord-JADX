package com.discord.utilities.systemlog;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: SystemLogUtils.kt */
/* renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetchLastTombstone$extractedGroups$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SystemLogUtils2 extends Lambda implements Function1<MatchResult, String> {
    public final /* synthetic */ Regex $removeDexNameExp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogUtils2(Regex regex) {
        super(1);
        this.$removeDexNameExp = regex;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(MatchResult matchResult) {
        return invoke2(matchResult);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(MatchResult matchResult) {
        Intrinsics3.checkNotNullParameter(matchResult, "it");
        return this.$removeDexNameExp.replace(matchResult.getGroupValues().get(1), "classesN.dex");
    }
}
