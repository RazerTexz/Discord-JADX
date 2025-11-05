package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandValue;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetKt {

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ApplicationCommandValue, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandValue applicationCommandValue) {
            m.checkNotNullParameter(applicationCommandValue, "it");
            return WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(applicationCommandValue, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandValue applicationCommandValue) {
            return invoke2(applicationCommandValue);
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ApplicationCommandValue, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandValue applicationCommandValue) {
            m.checkNotNullParameter(applicationCommandValue, "it");
            return WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(applicationCommandValue, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandValue applicationCommandValue) {
            return invoke2(applicationCommandValue);
        }
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        String strJoinToString$default;
        m.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        m.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandValue> listB = applicationCommandData.b();
        if (listB == null || (strJoinToString$default = u.joinToString$default(listB, " ", null, null, 0, null, new AnonymousClass1(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandValue applicationCommandValue, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        m.checkNotNullParameter(applicationCommandValue, "$this$toSlashCommandCopyString");
        m.checkNotNullParameter(map, "commandValues");
        if (applicationCommandValue.c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandValue.getName());
            sb.append(' ');
            List<ApplicationCommandValue> listC = applicationCommandValue.c();
            sb.append(listC != null ? u.joinToString$default(listC, " ", null, null, 0, null, new AnonymousClass2(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandValue.getName());
        sb2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = map.get(applicationCommandValue.getName());
        sb2.append(slashCommandParam != null ? slashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
