package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: AutocompleteViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$applyCommandOptionSpans$1$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel3 extends Lambda implements Function1<String, String> {
    public static final AutocompleteViewModel3 INSTANCE = new AutocompleteViewModel3();

    public AutocompleteViewModel3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        return AutocompleteCommandUtils.INSTANCE.transformParameterSpannableString(str);
    }
}
