package com.discord.views;

import android.widget.TextView;
import b.a.i.x0;
import com.discord.R;
import com.discord.api.auth.OAuthScope;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: OAuthPermissionViews.kt */
/* loaded from: classes2.dex */
public final class OAuthPermissionViews {

    /* compiled from: OAuthPermissionViews.kt */
    public static final class InvalidScopeException extends IllegalArgumentException {
        private final String scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidScopeException(String str) {
            super("invalid scope: " + str);
            m.checkNotNullParameter(str, "scope");
            this.scope = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getScope() {
            return this.scope;
        }
    }

    /* compiled from: OAuthPermissionViews.kt */
    public static final class a extends SimpleRecyclerAdapter.ViewHolder<OAuthScope> {
        public final x0 a;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(x0 x0Var) {
            m.checkNotNullParameter(x0Var, "binding");
            TextView textView = x0Var.a;
            m.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.a = x0Var;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(OAuthScope oAuthScope) throws InvalidScopeException {
            OAuthScope oAuthScope2 = oAuthScope;
            m.checkNotNullParameter(oAuthScope2, "data");
            TextView textView = this.a.a;
            m.checkNotNullExpressionValue(textView, "binding.root");
            OAuthPermissionViews.a(textView, oAuthScope2);
        }
    }

    public static final void a(TextView textView, OAuthScope oAuthScope) throws InvalidScopeException {
        int i;
        m.checkNotNullParameter(textView, "$this$setScopePermissionText");
        m.checkNotNullParameter(oAuthScope, "scope");
        if (m.areEqual(oAuthScope, OAuthScope.Identify.INSTANCE)) {
            i = R.string.scope_identify;
        } else if (m.areEqual(oAuthScope, OAuthScope.Email.INSTANCE)) {
            i = R.string.scope_email;
        } else if (m.areEqual(oAuthScope, OAuthScope.Connections.INSTANCE)) {
            i = R.string.scope_connections;
        } else if (m.areEqual(oAuthScope, OAuthScope.Guilds.INSTANCE)) {
            i = R.string.scope_guilds;
        } else if (m.areEqual(oAuthScope, OAuthScope.GuildsJoin.INSTANCE)) {
            i = R.string.scope_guilds_join;
        } else if (m.areEqual(oAuthScope, OAuthScope.GuildsMembersRead.INSTANCE)) {
            i = R.string.scope_guilds_members_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.GdmJoin.INSTANCE)) {
            i = R.string.scope_gdm_join;
        } else if (m.areEqual(oAuthScope, OAuthScope.Bot.INSTANCE)) {
            i = R.string.scope_bot;
        } else if (m.areEqual(oAuthScope, OAuthScope.WebhookIncoming.INSTANCE)) {
            i = R.string.scope_webhook_incoming;
        } else if (m.areEqual(oAuthScope, OAuthScope.Rpc.INSTANCE)) {
            i = R.string.scope_rpc;
        } else if (m.areEqual(oAuthScope, OAuthScope.RpcNotificationsRead.INSTANCE)) {
            i = R.string.scope_rpc_notifications_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.RpcVoiceRead.INSTANCE)) {
            i = R.string.scope_rpc_voice_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.RpcVoiceWrite.INSTANCE)) {
            i = R.string.scope_rpc_voice_write;
        } else if (m.areEqual(oAuthScope, OAuthScope.RpcActivitiesWrite.INSTANCE)) {
            i = R.string.scope_rpc_activities_write;
        } else if (m.areEqual(oAuthScope, OAuthScope.MessagesRead.INSTANCE)) {
            i = R.string.scope_messages_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsUpload.INSTANCE)) {
            i = R.string.scope_applications_builds_upload;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsRead.INSTANCE)) {
            i = R.string.scope_applications_builds_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsCommands.INSTANCE)) {
            i = R.string.scope_applications_commands;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsCommandsUpdate.INSTANCE)) {
            i = R.string.scope_applications_commands_update;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsStoreUpdate.INSTANCE)) {
            i = R.string.scope_applications_store_update;
        } else if (m.areEqual(oAuthScope, OAuthScope.ApplicationsEntitlements.INSTANCE)) {
            i = R.string.scope_applications_entitlements;
        } else if (m.areEqual(oAuthScope, OAuthScope.ActivitiesRead.INSTANCE)) {
            i = R.string.scope_activities_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.ActivitiesWrite.INSTANCE)) {
            i = R.string.scope_activities_write;
        } else if (m.areEqual(oAuthScope, OAuthScope.RelationshipsRead.INSTANCE)) {
            i = R.string.scope_relationships_read;
        } else if (m.areEqual(oAuthScope, OAuthScope.Voice.INSTANCE)) {
            i = R.string.scope_voice;
        } else {
            if (!m.areEqual(oAuthScope, OAuthScope.DMChannelsRead.INSTANCE)) {
                if (!(oAuthScope instanceof OAuthScope.Invalid)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new InvalidScopeException(((OAuthScope.Invalid) oAuthScope).getRawValue());
            }
            i = R.string.scope_dm_channels_read;
        }
        textView.setText(i);
    }
}
