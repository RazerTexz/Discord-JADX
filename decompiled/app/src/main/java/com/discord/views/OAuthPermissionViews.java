package com.discord.views;

import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.auth.OAuthScope;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import kotlin.NoWhenBranchMatchedException;
import p007b.p008a.p025i.OauthTokenPermissionListItemBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAuthPermissionViews {

    /* JADX INFO: compiled from: OAuthPermissionViews.kt */
    public static final class InvalidScopeException extends IllegalArgumentException {
        private final String scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidScopeException(String str) {
            super("invalid scope: " + str);
            Intrinsics3.checkNotNullParameter(str, "scope");
            this.scope = str;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getScope() {
            return this.scope;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.OAuthPermissionViews$a */
    /* JADX INFO: compiled from: OAuthPermissionViews.kt */
    public static final class C7080a extends SimpleRecyclerAdapter.ViewHolder<OAuthScope> {

        /* JADX INFO: renamed from: a */
        public final OauthTokenPermissionListItemBinding f19092a;

        /* JADX WARN: Illegal instructions before constructor call */
        public C7080a(OauthTokenPermissionListItemBinding oauthTokenPermissionListItemBinding) {
            Intrinsics3.checkNotNullParameter(oauthTokenPermissionListItemBinding, "binding");
            TextView textView = oauthTokenPermissionListItemBinding.f1367a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.f19092a = oauthTokenPermissionListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(OAuthScope oAuthScope) {
            OAuthScope oAuthScope2 = oAuthScope;
            Intrinsics3.checkNotNullParameter(oAuthScope2, "data");
            TextView textView = this.f19092a.f1367a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            OAuthPermissionViews.m8548a(textView, oAuthScope2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m8548a(TextView textView, OAuthScope oAuthScope) throws InvalidScopeException {
        int i;
        Intrinsics3.checkNotNullParameter(textView, "$this$setScopePermissionText");
        Intrinsics3.checkNotNullParameter(oAuthScope, "scope");
        if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Identify.INSTANCE)) {
            i = C5419R.string.scope_identify;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Email.INSTANCE)) {
            i = C5419R.string.scope_email;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Connections.INSTANCE)) {
            i = C5419R.string.scope_connections;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Guilds.INSTANCE)) {
            i = C5419R.string.scope_guilds;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GuildsJoin.INSTANCE)) {
            i = C5419R.string.scope_guilds_join;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GuildsMembersRead.INSTANCE)) {
            i = C5419R.string.scope_guilds_members_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GdmJoin.INSTANCE)) {
            i = C5419R.string.scope_gdm_join;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Bot.INSTANCE)) {
            i = C5419R.string.scope_bot;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.WebhookIncoming.INSTANCE)) {
            i = C5419R.string.scope_webhook_incoming;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Rpc.INSTANCE)) {
            i = C5419R.string.scope_rpc;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcNotificationsRead.INSTANCE)) {
            i = C5419R.string.scope_rpc_notifications_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcVoiceRead.INSTANCE)) {
            i = C5419R.string.scope_rpc_voice_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcVoiceWrite.INSTANCE)) {
            i = C5419R.string.scope_rpc_voice_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcActivitiesWrite.INSTANCE)) {
            i = C5419R.string.scope_rpc_activities_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.MessagesRead.INSTANCE)) {
            i = C5419R.string.scope_messages_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsUpload.INSTANCE)) {
            i = C5419R.string.scope_applications_builds_upload;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsRead.INSTANCE)) {
            i = C5419R.string.scope_applications_builds_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsCommands.INSTANCE)) {
            i = C5419R.string.scope_applications_commands;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsCommandsUpdate.INSTANCE)) {
            i = C5419R.string.scope_applications_commands_update;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsStoreUpdate.INSTANCE)) {
            i = C5419R.string.scope_applications_store_update;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsEntitlements.INSTANCE)) {
            i = C5419R.string.scope_applications_entitlements;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ActivitiesRead.INSTANCE)) {
            i = C5419R.string.scope_activities_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ActivitiesWrite.INSTANCE)) {
            i = C5419R.string.scope_activities_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RelationshipsRead.INSTANCE)) {
            i = C5419R.string.scope_relationships_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Voice.INSTANCE)) {
            i = C5419R.string.scope_voice;
        } else {
            if (!Intrinsics3.areEqual(oAuthScope, OAuthScope.DMChannelsRead.INSTANCE)) {
                if (!(oAuthScope instanceof OAuthScope.Invalid)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new InvalidScopeException(((OAuthScope.Invalid) oAuthScope).getRawValue());
            }
            i = C5419R.string.scope_dm_channels_read;
        }
        textView.setText(i);
    }
}
