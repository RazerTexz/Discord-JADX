package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
/* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet5 {

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1 */
    public static final class C81671 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81671(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            return invoke2(applicationCommandData3);
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2 */
    public static final class C81682 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81682(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            return invoke2(applicationCommandData3);
        }
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        String strJoinToString$default;
        Intrinsics3.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandData3> listM7725b = applicationCommandData.m7725b();
        if (listM7725b == null || (strJoinToString$default = _Collections.joinToString$default(listM7725b, " ", null, null, 0, null, new C81671(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData3 applicationCommandData3, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        if (applicationCommandData3.m7741c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandData3.getName());
            sb.append(' ');
            List<ApplicationCommandData3> listM7741c = applicationCommandData3.m7741c();
            sb.append(listM7741c != null ? _Collections.joinToString$default(listM7741c, " ", null, null, 0, null, new C81682(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandData3.getName());
        sb2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = map.get(applicationCommandData3.getName());
        sb2.append(slashCommandParam != null ? slashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
