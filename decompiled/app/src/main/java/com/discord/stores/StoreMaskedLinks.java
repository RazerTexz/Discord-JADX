package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.User;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: StoreMaskedLinks.kt */
/* loaded from: classes2.dex */
public final class StoreMaskedLinks extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Regex DISCORD_DOMAINS_REGEX;
    private static final String HOST_SPOTIFY = "https://spotify.com";
    private static final String HOST_SPOTIFY_OPEN = "https://open.spotify.com";
    private static final List<String> TRUSTED_DOMAINS;
    private static final String USER_TRUSTED_DOMAINS_CACHE_KEY = "USER_TRUSTED_DOMAINS_CACHE_KEY";
    private final Dispatcher dispatcher;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreUserRelationships storeUserRelationships;
    private Set<String> userTrustedDomains;
    private Set<String> userTrustedDomainsSnapshot;

    /* compiled from: StoreMaskedLinks.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getDomainName(Companion companion, String str) {
            return companion.getDomainName(str);
        }

        private final String getDomainName(String url) {
            try {
                Uri uri = Uri.parse(url);
                m.checkNotNullExpressionValue(uri, "Uri.parse(url)");
                return uri.getHost();
            } catch (Exception unused) {
                return null;
            }
        }

        @VisibleForTesting
        public final boolean isImplicitlyTrustedDomain$app_productionGoogleRelease(String name) {
            m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return StoreMaskedLinks.access$getTRUSTED_DOMAINS$cp().contains(name) || StoreMaskedLinks.access$getDISCORD_DOMAINS_REGEX$cp().containsMatchIn(name);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMaskedLinks.kt */
    /* renamed from: com.discord.stores.StoreMaskedLinks$trustDomain$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$url = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strAccess$getDomainName = Companion.access$getDomainName(StoreMaskedLinks.INSTANCE, this.$url);
            if (strAccess$getDomainName != null) {
                StoreMaskedLinks.access$getUserTrustedDomains$p(StoreMaskedLinks.this).add(strAccess$getDomainName);
                StoreMaskedLinks.this.markChanged();
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TRUSTED_DOMAINS = n.listOfNotNull((Object[]) new String[]{Companion.access$getDomainName(companion, BuildConfig.HOST), Companion.access$getDomainName(companion, BuildConfig.HOST_ALTERNATE), Companion.access$getDomainName(companion, BuildConfig.HOST_CDN), Companion.access$getDomainName(companion, BuildConfig.HOST_GIFT), Companion.access$getDomainName(companion, BuildConfig.HOST_INVITE), Companion.access$getDomainName(companion, BuildConfig.HOST_GUILD_TEMPLATE), Companion.access$getDomainName(companion, HOST_SPOTIFY), Companion.access$getDomainName(companion, HOST_SPOTIFY_OPEN)});
        DISCORD_DOMAINS_REGEX = new Regex("(?:^|\\.)(?:discordapp|discord)\\.com$");
    }

    public StoreMaskedLinks(Dispatcher dispatcher, StoreChannelsSelected storeChannelsSelected, StoreUserRelationships storeUserRelationships) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.dispatcher = dispatcher;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUserRelationships = storeUserRelationships;
        this.userTrustedDomainsSnapshot = n0.emptySet();
        this.userTrustedDomains = new LinkedHashSet();
    }

    public static final /* synthetic */ Regex access$getDISCORD_DOMAINS_REGEX$cp() {
        return DISCORD_DOMAINS_REGEX;
    }

    public static final /* synthetic */ List access$getTRUSTED_DOMAINS$cp() {
        return TRUSTED_DOMAINS;
    }

    public static final /* synthetic */ Set access$getUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks) {
        return storeMaskedLinks.userTrustedDomains;
    }

    public static final /* synthetic */ void access$setUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks, Set set) {
        storeMaskedLinks.userTrustedDomains = set;
    }

    public final Set<String> getUserTrustedDomains() {
        return this.userTrustedDomainsSnapshot;
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, n0.emptySet());
        if (stringSet == null) {
            stringSet = new LinkedHashSet<>();
        }
        this.userTrustedDomains = new HashSet(stringSet);
        markChanged();
    }

    public final boolean isTrustedDomain(String url, String mask) {
        m.checkNotNullParameter(url, "url");
        if (isTrustedDomain(url)) {
            return true;
        }
        boolean z2 = mask == null || m.areEqual(mask, url);
        Channel selectedChannel = this.storeChannelsSelected.getSelectedChannel();
        User userA = selectedChannel != null ? ChannelUtils.a(selectedChannel) : null;
        if (ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(userA != null ? Long.valueOf(userA.getId()) : null), 1)) {
            return z2;
        }
        return false;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.userTrustedDomainsSnapshot = new HashSet(this.userTrustedDomains);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, this.userTrustedDomainsSnapshot);
        editorEdit.apply();
    }

    public final void trustDomain(String url) {
        m.checkNotNullParameter(url, "url");
        this.dispatcher.schedule(new AnonymousClass1(url));
    }

    private final boolean isTrustedDomain(String url) {
        Companion companion = INSTANCE;
        String strAccess$getDomainName = Companion.access$getDomainName(companion, url);
        return u.contains(this.userTrustedDomainsSnapshot, strAccess$getDomainName) || (strAccess$getDomainName != null && companion.isImplicitlyTrustedDomain$app_productionGoogleRelease(strAccess$getDomainName));
    }
}
