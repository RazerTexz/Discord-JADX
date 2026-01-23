package com.discord.utilities.channel;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import java.util.Map;
import kotlin.Tuples2;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p027k.FormatUtils;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.channel.ChannelPermissionUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: ChannelPermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionUtils {
    public static final Map<Integer, ChannelPermissionUtils2> getCategoryLabels(boolean z2, Context context) {
        String str;
        CharSequence charSequenceM216h;
        CharSequence charSequenceM216h2;
        String str2;
        CharSequence charSequenceM216h3;
        CharSequence charSequenceM216h4;
        String str3;
        CharSequence charSequenceM216h5;
        CharSequence charSequenceM216h6;
        Intrinsics3.checkNotNullParameter(context, "context");
        Tuples2[] tuples2Arr = new Tuples2[29];
        Integer numValueOf = Integer.valueOf(C5419R.id.channel_permission_text_read_messages);
        String string = context.getString(C5419R.string.role_permissions_view_channel);
        String string2 = context.getString(C5419R.string.role_permissions_view_channel_description_category);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…nel_description_category)");
        tuples2Arr[0] = Tuples.m10073to(numValueOf, new ChannelPermissionUtils2(string2, string, null, null, context.getString(C5419R.string.role_permissions_view_channel_description_text_everyone), context.getString(C5419R.string.role_permissions_view_channel_description_voice_everyone), null, context.getString(C5419R.string.role_permissions_view_channel_description_category_everyone), null, 332, null));
        Integer numValueOf2 = Integer.valueOf(C5419R.id.channel_permission_general_manage_channel);
        String string3 = context.getString(C5419R.string.manage_channels);
        String string4 = context.getString(C5419R.string.role_permissions_manage_channel_description_category);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.stri…nel_description_category)");
        tuples2Arr[1] = Tuples.m10073to(numValueOf2, new ChannelPermissionUtils2(string4, string3, context.getString(C5419R.string.role_permissions_manage_channel_description_voice), context.getString(C5419R.string.role_permissions_manage_channel_description_stage), null, null, null, null, null, 496, null));
        Integer numValueOf3 = Integer.valueOf(C5419R.id.channel_permission_general_manage_threads);
        String string5 = context.getString(C5419R.string.role_permissions_manage_threads_description_category);
        Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.stri…ads_description_category)");
        tuples2Arr[2] = Tuples.m10073to(numValueOf3, new ChannelPermissionUtils2(string5, null, null, null, null, null, null, context.getString(C5419R.string.role_permissions_manage_threads_description_category), null, 382, null));
        Integer numValueOf4 = Integer.valueOf(C5419R.id.channel_permission_general_manage_permissions);
        String string6 = context.getString(C5419R.string.role_permissions_manage_roles_description_category);
        Intrinsics3.checkNotNullExpressionValue(string6, "context.getString(R.stri…les_description_category)");
        tuples2Arr[3] = Tuples.m10073to(numValueOf4, new ChannelPermissionUtils2(string6, null, null, context.getString(C5419R.string.role_permissions_manage_roles_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf5 = Integer.valueOf(C5419R.id.channel_permission_general_manage_webhooks);
        String string7 = context.getString(C5419R.string.role_permissions_manage_webhooks_description_category);
        Intrinsics3.checkNotNullExpressionValue(string7, "context.getString(R.stri…oks_description_category)");
        tuples2Arr[4] = Tuples.m10073to(numValueOf5, new ChannelPermissionUtils2(string7, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf6 = Integer.valueOf(C5419R.id.channel_permission_text_send_messages);
        String string8 = context.getString(C5419R.string.role_permissions_send_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string8, "context.getString(R.stri…ges_description_category)");
        AppHelpDesk appHelpDesk = AppHelpDesk.f507a;
        tuples2Arr[5] = Tuples.m10073to(numValueOf6, new ChannelPermissionUtils2(string8, null, null, null, null, null, null, null, FormatUtils.m216h(context, C5419R.string.role_permissions_send_messages_description_announcement, new Object[]{appHelpDesk.m149a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf7 = Integer.valueOf(C5419R.id.channel_permission_text_send_messages_in_threads);
        if (z2) {
            charSequenceM216h = context.getString(C5419R.string.role_permissions_send_messages_in_threads_description_category);
            str = "context.getString(R.stri…ads_description_category)";
            Intrinsics3.checkNotNullExpressionValue(charSequenceM216h, str);
        } else {
            str = "context.getString(R.stri…ads_description_category)";
            charSequenceM216h = FormatUtils.m216h(context, C5419R.string.f14771x98d4cb90, new Object[0], null, 4);
        }
        if (z2) {
            String string9 = context.getString(C5419R.string.role_permissions_send_messages_in_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string9, str);
            charSequenceM216h2 = string9;
        } else {
            charSequenceM216h2 = FormatUtils.m216h(context, C5419R.string.f14771x98d4cb90, new Object[0], null, 4);
        }
        String str4 = str;
        tuples2Arr[6] = Tuples.m10073to(numValueOf7, new ChannelPermissionUtils2(charSequenceM216h, null, null, null, null, null, null, charSequenceM216h2, null, 382, null));
        Integer numValueOf8 = Integer.valueOf(C5419R.id.channel_permission_text_create_public_threads);
        if (z2) {
            charSequenceM216h3 = context.getString(C5419R.string.role_permissions_create_public_threads_description_category);
            str2 = str4;
            Intrinsics3.checkNotNullExpressionValue(charSequenceM216h3, str2);
        } else {
            str2 = str4;
            charSequenceM216h3 = FormatUtils.m216h(context, C5419R.string.f14770x8ac810cf, new Object[0], null, 4);
        }
        if (z2) {
            String string10 = context.getString(C5419R.string.role_permissions_create_public_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string10, str2);
            charSequenceM216h4 = string10;
        } else {
            charSequenceM216h4 = FormatUtils.m216h(context, C5419R.string.f14770x8ac810cf, new Object[0], null, 4);
        }
        CharSequence charSequence = charSequenceM216h4;
        String str5 = str2;
        tuples2Arr[7] = Tuples.m10073to(numValueOf8, new ChannelPermissionUtils2(charSequenceM216h3, null, null, null, null, null, null, charSequence, null, 382, null));
        Integer numValueOf9 = Integer.valueOf(C5419R.id.channel_permission_text_create_private_threads);
        if (z2) {
            charSequenceM216h5 = context.getString(C5419R.string.role_permissions_create_private_threads_description_category);
            str3 = str5;
            Intrinsics3.checkNotNullExpressionValue(charSequenceM216h5, str3);
        } else {
            str3 = str5;
            charSequenceM216h5 = FormatUtils.m216h(context, C5419R.string.f14769x19ffc831, new Object[0], null, 4);
        }
        if (z2) {
            String string11 = context.getString(C5419R.string.role_permissions_create_private_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string11, str3);
            charSequenceM216h6 = string11;
        } else {
            charSequenceM216h6 = FormatUtils.m216h(context, C5419R.string.f14769x19ffc831, new Object[0], null, 4);
        }
        tuples2Arr[8] = Tuples.m10073to(numValueOf9, new ChannelPermissionUtils2(charSequenceM216h5, null, null, null, null, null, null, charSequenceM216h6, null, 382, null));
        Integer numValueOf10 = Integer.valueOf(C5419R.id.channel_permission_general_create_instant_invite);
        String string12 = context.getString(C5419R.string.role_permissions_create_instant_invite_description_category);
        Intrinsics3.checkNotNullExpressionValue(string12, "context.getString(R.stri…ite_description_category)");
        tuples2Arr[9] = Tuples.m10073to(numValueOf10, new ChannelPermissionUtils2(string12, null, context.getString(C5419R.string.role_permissions_create_instant_invite_description_voice), null, null, null, null, null, null, 506, null));
        Integer numValueOf11 = Integer.valueOf(C5419R.id.channel_permission_text_embed_links);
        String string13 = context.getString(C5419R.string.role_permissions_embed_links_description_category);
        Intrinsics3.checkNotNullExpressionValue(string13, "context.getString(R.stri…nks_description_category)");
        tuples2Arr[10] = Tuples.m10073to(numValueOf11, new ChannelPermissionUtils2(string13, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf12 = Integer.valueOf(C5419R.id.channel_permission_text_attach_files);
        String string14 = context.getString(C5419R.string.role_permissions_attach_files_description_category);
        Intrinsics3.checkNotNullExpressionValue(string14, "context.getString(R.stri…les_description_category)");
        tuples2Arr[11] = Tuples.m10073to(numValueOf12, new ChannelPermissionUtils2(string14, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf13 = Integer.valueOf(C5419R.id.channel_permission_text_add_reactions);
        String string15 = context.getString(C5419R.string.role_permissions_add_reactions_description_category);
        Intrinsics3.checkNotNullExpressionValue(string15, "context.getString(R.stri…ons_description_category)");
        tuples2Arr[12] = Tuples.m10073to(numValueOf13, new ChannelPermissionUtils2(string15, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf14 = Integer.valueOf(C5419R.id.channel_permission_text_use_external_emojis);
        String string16 = context.getString(C5419R.string.role_permissions_use_external_emojis_description_category);
        Intrinsics3.checkNotNullExpressionValue(string16, "context.getString(R.stri…jis_description_category)");
        tuples2Arr[13] = Tuples.m10073to(numValueOf14, new ChannelPermissionUtils2(string16, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf15 = Integer.valueOf(C5419R.id.channel_permission_text_use_external_stickers);
        String string17 = context.getString(C5419R.string.role_permissions_use_external_stickers_description_category);
        Intrinsics3.checkNotNullExpressionValue(string17, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[14] = Tuples.m10073to(numValueOf15, new ChannelPermissionUtils2(string17, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf16 = Integer.valueOf(C5419R.id.channel_permission_text_mention_everyone);
        String string18 = context.getString(C5419R.string.role_permissions_mention_everyone_description_category);
        Intrinsics3.checkNotNullExpressionValue(string18, "context.getString(R.stri…one_description_category)");
        tuples2Arr[15] = Tuples.m10073to(numValueOf16, new ChannelPermissionUtils2(string18, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf17 = Integer.valueOf(C5419R.id.channel_permission_text_manage_messages);
        String string19 = context.getString(C5419R.string.role_permissions_manage_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string19, "context.getString(R.stri…ges_description_category)");
        tuples2Arr[16] = Tuples.m10073to(numValueOf17, new ChannelPermissionUtils2(string19, null, null, null, null, null, null, null, FormatUtils.m216h(context, C5419R.string.role_permissions_manage_messages_description_announcement, new Object[]{appHelpDesk.m149a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf18 = Integer.valueOf(C5419R.id.channel_permission_text_read_message_history);
        String string20 = context.getString(C5419R.string.role_permissions_read_message_history_description_category);
        Intrinsics3.checkNotNullExpressionValue(string20, "context.getString(R.stri…ory_description_category)");
        tuples2Arr[17] = Tuples.m10073to(numValueOf18, new ChannelPermissionUtils2(string20, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf19 = Integer.valueOf(C5419R.id.channel_permission_text_send_tts_messages);
        String string21 = context.getString(C5419R.string.role_permissions_send_tts_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string21, "context.getString(R.stri…ges_description_category)");
        tuples2Arr[18] = Tuples.m10073to(numValueOf19, new ChannelPermissionUtils2(string21, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf20 = Integer.valueOf(C5419R.id.channel_permission_voice_connect);
        String string22 = context.getString(C5419R.string.role_permissions_connect_description_category);
        Intrinsics3.checkNotNullExpressionValue(string22, "context.getString(R.stri…ect_description_category)");
        tuples2Arr[19] = Tuples.m10073to(numValueOf20, new ChannelPermissionUtils2(string22, null, null, context.getString(C5419R.string.role_permissions_connect_description_stage), null, context.getString(C5419R.string.role_permissions_connect_description_voice_everyone), context.getString(C5419R.string.role_permissions_connect_description_stage_everyone), context.getString(C5419R.string.role_permissions_connect_description_category_everyone), null, 278, null));
        Integer numValueOf21 = Integer.valueOf(C5419R.id.channel_permission_voice_speak);
        String string23 = context.getString(C5419R.string.role_permissions_speak_description_category);
        Intrinsics3.checkNotNullExpressionValue(string23, "context.getString(R.stri…eak_description_category)");
        tuples2Arr[20] = Tuples.m10073to(numValueOf21, new ChannelPermissionUtils2(string23, null, null, context.getString(C5419R.string.role_permissions_speak_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf22 = Integer.valueOf(C5419R.id.channel_permission_voice_video);
        String string24 = context.getString(C5419R.string.role_permissions_stream_description_category);
        Intrinsics3.checkNotNullExpressionValue(string24, "context.getString(R.stri…eam_description_category)");
        tuples2Arr[21] = Tuples.m10073to(numValueOf22, new ChannelPermissionUtils2(string24, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf23 = Integer.valueOf(C5419R.id.channel_permission_voice_use_vad);
        String string25 = context.getString(C5419R.string.role_permissions_use_vad_description_category);
        Intrinsics3.checkNotNullExpressionValue(string25, "context.getString(R.stri…vad_description_category)");
        tuples2Arr[22] = Tuples.m10073to(numValueOf23, new ChannelPermissionUtils2(string25, null, null, context.getString(C5419R.string.role_permissions_use_vad_description_stage), null, null, null, null, null, 502, null));
        tuples2Arr[23] = Tuples.m10073to(Integer.valueOf(C5419R.id.channel_permission_voice_priority_speaker), new ChannelPermissionUtils2(FormatUtils.m216h(context, C5419R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{FormatUtils.m216h(context, C5419R.string.keybind_push_to_talk_priority, new Object[0], null, 4)}, null, 4), null, null, null, null, null, null, FormatUtils.m216h(context, C5419R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{FormatUtils.m216h(context, C5419R.string.keybind_push_to_talk_priority, new Object[0], null, 4)}, null, 4), null, 382, null));
        tuples2Arr[24] = Tuples.m10073to(Integer.valueOf(C5419R.id.channel_permission_voice_mute_members), new ChannelPermissionUtils2(FormatUtils.m216h(context, C5419R.string.role_permissions_mute_members_description_category, new Object[0], null, 4), null, null, FormatUtils.m216h(context, C5419R.string.role_permissions_mute_members_description_stage, new Object[0], null, 4), null, null, null, null, null, 502, null));
        Integer numValueOf24 = Integer.valueOf(C5419R.id.channel_permission_voice_deafen_members);
        String string26 = context.getString(C5419R.string.role_permissions_deafen_members_description_category);
        Intrinsics3.checkNotNullExpressionValue(string26, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[25] = Tuples.m10073to(numValueOf24, new ChannelPermissionUtils2(string26, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf25 = Integer.valueOf(C5419R.id.channel_permission_voice_move_members);
        String string27 = context.getString(C5419R.string.role_permissions_move_members_description_category);
        Intrinsics3.checkNotNullExpressionValue(string27, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[26] = Tuples.m10073to(numValueOf25, new ChannelPermissionUtils2(string27, null, null, context.getString(C5419R.string.role_permissions_move_members_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf26 = Integer.valueOf(C5419R.id.channel_permission_stage_request_to_speak);
        String string28 = context.getString(C5419R.string.role_permissions_request_to_speak_description_category);
        Intrinsics3.checkNotNullExpressionValue(string28, "context.getString(R.stri…eak_description_category)");
        tuples2Arr[27] = Tuples.m10073to(numValueOf26, new ChannelPermissionUtils2(string28, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf27 = Integer.valueOf(C5419R.id.channel_permission_events_manage_events);
        String string29 = context.getString(C5419R.string.role_permissions_manage_events_description_category);
        Intrinsics3.checkNotNullExpressionValue(string29, "context.getString(R.stri…nts_description_category)");
        tuples2Arr[28] = Tuples.m10073to(numValueOf27, new ChannelPermissionUtils2(string29, null, null, null, null, null, null, null, null, 510, null));
        return Maps6.hashMapOf(tuples2Arr);
    }

    @StringRes
    public static final int getChannelPermissionOwnerRoleLabel(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "role");
        return (guildRole.getPermissions() & 8) == 8 ? C5419R.string.private_channel_add_members_modal_row_administrator : C5419R.string.private_channel_add_members_modal_row_role;
    }
}
