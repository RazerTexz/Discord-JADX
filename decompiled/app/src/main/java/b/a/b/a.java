package b.a.b;

import b.i.d.e;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityPlatformTypeAdapter;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityTypeTypeAdapter;
import com.discord.api.application.ApplicationType;
import com.discord.api.application.ApplicationTypeAdapter;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.auth.RequiredAction;
import com.discord.api.auth.RequiredActionTypeAdapter;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ButtonStyleTypeAdapter;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.TextStyle;
import com.discord.api.botuikit.TextStyleTypeAdapter;
import com.discord.api.botuikit.gson.ComponentRuntimeTypeAdapter;
import com.discord.api.botuikit.gson.ComponentTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermissionType;
import com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandTypeAdapter;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType;
import com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildExplicitContentFilterTypeAdapter;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildHubTypeTypeAdapter;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsersTypeAdapter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.GuildVerificationLevelTypeAdapter;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.ApplicationStatusTypeAdapter;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.discord.api.guildrolesubscription.PayoutGroupStatusTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.discord.api.guildrolesubscription.PayoutGroupTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.PayoutStatusAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatusTypeAdapter;
import com.discord.api.localizedstring.LocalizedString;
import com.discord.api.localizedstring.LocalizedStringTypeAdapter;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.activity.MessageActivityTypeTypeAdapter;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedTypeTypeAdapter;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.PremiumTierTypeAdapter;
import com.discord.api.premium.PriceTierType;
import com.discord.api.premium.PriceTierTypeAdapter;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButtonTypeAdapter;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeChildTypeAdapter;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportNodeElementDataTypeAdapter;
import com.discord.api.science.AnalyticsSchemaTypeAdapter;
import com.discord.api.science.Science;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerFormatTypeTypeAdapter;
import com.discord.api.sticker.StickerType;
import com.discord.api.sticker.StickerTypeTypeAdapter;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.NsfwAllowanceTypeAdapter;
import com.discord.api.user.Phone;
import com.discord.api.user.PhoneTypeAdapter;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.utcdatetime.UtcDateTimeTypeAdapter;
import com.discord.nullserializable.NullSerializableTypeAdapterFactory;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: TypeAdapterRegistrar.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final Map<Class<? extends Object>, Function0<Object>> a = h0.mapOf(o.to(ActivityPlatform.class, b.j), o.to(ActivityType.class, C0029a.D), o.to(ActivityType.class, C0029a.O), o.to(AllowedInSuggestionsType.class, C0029a.P), o.to(ApplicationCommandPermissionType.class, C0029a.Q), o.to(ApplicationCommandType.class, C0029a.R), o.to(ApplicationStatus.class, C0029a.S), o.to(ApplicationType.class, C0029a.T), o.to(ButtonStyle.class, C0029a.U), o.to(ComponentType.class, C0029a.j), o.to(EmbedType.class, C0029a.k), o.to(FriendSuggestionReasonType.class, C0029a.l), o.to(GuildExplicitContentFilter.class, C0029a.m), o.to(GuildHubType.class, C0029a.n), o.to(GuildMaxVideoChannelUsers.class, C0029a.o), o.to(GuildRoleSubscriptionBenefitType.class, C0029a.p), o.to(GuildScheduledEventEntityType.class, C0029a.q), o.to(GuildScheduledEventStatus.class, C0029a.r), o.to(GuildVerificationLevel.class, C0029a.f52s), o.to(LocalizedString.class, C0029a.t), o.to(MessageActivityType.class, C0029a.u), o.to(NsfwAllowance.class, C0029a.v), o.to(OAuthScope.class, C0029a.w), o.to(PayoutGroupStatus.class, C0029a.f53x), o.to(PayoutGroupType.class, C0029a.f54y), o.to(PayoutStatus.class, C0029a.f55z), o.to(Phone.class, C0029a.A), o.to(PremiumTier.class, C0029a.B), o.to(PriceTierType.class, C0029a.C), o.to(ReportNodeBottomButton.class, C0029a.E), o.to(ReportNodeChild.class, C0029a.F), o.to(ReportNodeElementData.class, C0029a.G), o.to(RequiredAction.class, C0029a.H), o.to(Science.Event.SchemaObject.class, C0029a.I), o.to(StageInstancePrivacyLevel.class, C0029a.J), o.to(StickerFormatType.class, C0029a.K), o.to(StickerType.class, C0029a.L), o.to(TextStyle.class, C0029a.M), o.to(UtcDateTime.class, C0029a.N));

    /* renamed from: b, reason: collision with root package name */
    public static final List<b.i.d.o> f51b = n.listOf((Object[]) new b.i.d.o[]{ComponentRuntimeTypeAdapter.INSTANCE.a(), new NullSerializableTypeAdapterFactory()});

    /* compiled from: kotlin-style lambda group */
    /* renamed from: b.a.b.a$a, reason: collision with other inner class name */
    public static final class C0029a extends d0.z.d.o implements Function0<Object> {
        public final /* synthetic */ int V;
        public static final C0029a j = new C0029a(0);
        public static final C0029a k = new C0029a(1);
        public static final C0029a l = new C0029a(2);
        public static final C0029a m = new C0029a(3);
        public static final C0029a n = new C0029a(4);
        public static final C0029a o = new C0029a(5);
        public static final C0029a p = new C0029a(6);
        public static final C0029a q = new C0029a(7);
        public static final C0029a r = new C0029a(8);

        /* renamed from: s, reason: collision with root package name */
        public static final C0029a f52s = new C0029a(9);
        public static final C0029a t = new C0029a(10);
        public static final C0029a u = new C0029a(11);
        public static final C0029a v = new C0029a(12);
        public static final C0029a w = new C0029a(13);

        /* renamed from: x, reason: collision with root package name */
        public static final C0029a f53x = new C0029a(14);

        /* renamed from: y, reason: collision with root package name */
        public static final C0029a f54y = new C0029a(15);

        /* renamed from: z, reason: collision with root package name */
        public static final C0029a f55z = new C0029a(16);
        public static final C0029a A = new C0029a(17);
        public static final C0029a B = new C0029a(18);
        public static final C0029a C = new C0029a(19);
        public static final C0029a D = new C0029a(20);
        public static final C0029a E = new C0029a(21);
        public static final C0029a F = new C0029a(22);
        public static final C0029a G = new C0029a(23);
        public static final C0029a H = new C0029a(24);
        public static final C0029a I = new C0029a(25);
        public static final C0029a J = new C0029a(26);
        public static final C0029a K = new C0029a(27);
        public static final C0029a L = new C0029a(28);
        public static final C0029a M = new C0029a(29);
        public static final C0029a N = new C0029a(30);
        public static final C0029a O = new C0029a(31);
        public static final C0029a P = new C0029a(32);
        public static final C0029a Q = new C0029a(33);
        public static final C0029a R = new C0029a(34);
        public static final C0029a S = new C0029a(35);
        public static final C0029a T = new C0029a(36);
        public static final C0029a U = new C0029a(37);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0029a(int i) {
            super(0);
            this.V = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.V) {
                case 0:
                    return new ComponentTypeTypeAdapter();
                case 1:
                    return new EmbedTypeTypeAdapter();
                case 2:
                    return new FriendSuggestionReasonTypeAdapter();
                case 3:
                    return new GuildExplicitContentFilterTypeAdapter();
                case 4:
                    return new GuildHubTypeTypeAdapter();
                case 5:
                    return new GuildMaxVideoChannelUsersTypeAdapter();
                case 6:
                    return new GuildRoleSubscriptionBenefitTypeAdapter();
                case 7:
                    return new GuildScheduledEventEntityTypeTypeAdapter();
                case 8:
                    return new GuildScheduledEventStatusTypeAdapter();
                case 9:
                    return new GuildVerificationLevelTypeAdapter();
                case 10:
                    return new LocalizedStringTypeAdapter();
                case 11:
                    return new MessageActivityTypeTypeAdapter();
                case 12:
                    return new NsfwAllowanceTypeAdapter();
                case 13:
                    return new OAuthScopeTypeAdapter();
                case 14:
                    return new PayoutGroupStatusTypeAdapter();
                case 15:
                    return new PayoutGroupTypeAdapter();
                case 16:
                    return new PayoutStatusAdapter();
                case 17:
                    return new PhoneTypeAdapter();
                case 18:
                    return new PremiumTierTypeAdapter();
                case 19:
                    return new PriceTierTypeAdapter();
                case 20:
                    return new ActivityTypeTypeAdapter();
                case 21:
                    return new ReportNodeBottomButtonTypeAdapter();
                case 22:
                    return new ReportNodeChildTypeAdapter();
                case 23:
                    return new ReportNodeElementDataTypeAdapter();
                case 24:
                    return new RequiredActionTypeAdapter();
                case 25:
                    return new AnalyticsSchemaTypeAdapter();
                case 26:
                    return new StageInstancePrivacyLevelTypeAdapter();
                case 27:
                    return new StickerFormatTypeTypeAdapter();
                case 28:
                    return new StickerTypeTypeAdapter();
                case 29:
                    return new TextStyleTypeAdapter();
                case 30:
                    return new UtcDateTimeTypeAdapter();
                case 31:
                    return new ActivityTypeTypeAdapter();
                case 32:
                    return new AllowedInSuggestionsTypeAdapter();
                case 33:
                    return new ApplicationCommandPermissionTypeTypeAdapter();
                case 34:
                    return new CommandTypeAdapter();
                case 35:
                    return new ApplicationStatusTypeAdapter();
                case 36:
                    return new ApplicationTypeAdapter();
                case 37:
                    return new ButtonStyleTypeAdapter();
                default:
                    throw null;
            }
        }
    }

    /* compiled from: TypeAdapterRegistrar.kt */
    public static final class b extends d0.z.d.o implements Function0<ActivityPlatformTypeAdapter> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityPlatformTypeAdapter invoke() {
            return new ActivityPlatformTypeAdapter();
        }
    }

    public static final e a(e eVar) {
        m.checkNotNullParameter(eVar, "$this$registerDiscordApiTypeAdapters");
        for (Map.Entry<Class<? extends Object>, Function0<Object>> entry : a.entrySet()) {
            eVar.b(entry.getKey(), entry.getValue().invoke());
        }
        m.checkNotNullParameter(eVar, "$this$registerDiscordApiTypeAdapterFactories");
        Iterator<T> it = f51b.iterator();
        while (it.hasNext()) {
            eVar.e.add((b.i.d.o) it.next());
        }
        return eVar;
    }
}
