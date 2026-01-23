package p007b.p008a.p017b;

import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityPlatform2;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityType2;
import com.discord.api.application.ApplicationType;
import com.discord.api.application.ApplicationType2;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.auth.RequiredAction;
import com.discord.api.auth.RequiredAction2;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.ButtonComponent3;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.TextComponent2;
import com.discord.api.botuikit.TextComponent3;
import com.discord.api.botuikit.gson.ComponentRuntimeTypeAdapter;
import com.discord.api.botuikit.gson.ComponentTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermission2;
import com.discord.api.commands.ApplicationCommandPermission3;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.ApplicationCommandType2;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType2;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType2;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildExplicitContentFilter2;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildHubType2;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers2;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.GuildVerificationLevel2;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.ApplicationStatus2;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType2;
import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.discord.api.guildrolesubscription.PayoutGroupStatus2;
import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.discord.api.guildrolesubscription.PayoutGroupType2;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.PayoutStatus2;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType2;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus2;
import com.discord.api.localizedstring.LocalizedString;
import com.discord.api.localizedstring.LocalizedString2;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.activity.MessageActivityType2;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedType3;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.PremiumTier2;
import com.discord.api.premium.PriceTierType;
import com.discord.api.premium.PriceTierType2;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButtonTypeAdapter;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeChildTypeAdapter;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportNodeElementDataTypeAdapter;
import com.discord.api.science.AnalyticsSchemaTypeAdapter;
import com.discord.api.science.Science;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.stageinstance.StageInstancePrivacyLevel2;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerFormatType2;
import com.discord.api.sticker.StickerType;
import com.discord.api.sticker.StickerType2;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.NsfwAllowance2;
import com.discord.api.user.Phone;
import com.discord.api.user.Phone2;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.utcdatetime.UtcDateTime2;
import com.discord.nullserializable.NullSerializable3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p007b.p225i.p408d.GsonBuilder;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapterRegistrar {

    /* JADX INFO: renamed from: a */
    public static final Map<Class<? extends Object>, Function0<Object>> f454a = Maps6.mapOf(Tuples.m10073to(ActivityPlatform.class, b.f495j), Tuples.m10073to(ActivityType.class, a.f459D), Tuples.m10073to(ActivityType.class, a.f470O), Tuples.m10073to(AllowedInSuggestionsType.class, a.f471P), Tuples.m10073to(ApplicationCommandPermission2.class, a.f472Q), Tuples.m10073to(ApplicationCommandType.class, a.f473R), Tuples.m10073to(ApplicationStatus.class, a.f474S), Tuples.m10073to(ApplicationType.class, a.f475T), Tuples.m10073to(ButtonComponent2.class, a.f476U), Tuples.m10073to(Component6.class, a.f477j), Tuples.m10073to(EmbedType.class, a.f478k), Tuples.m10073to(FriendSuggestionReasonType.class, a.f479l), Tuples.m10073to(GuildExplicitContentFilter.class, a.f480m), Tuples.m10073to(GuildHubType.class, a.f481n), Tuples.m10073to(GuildMaxVideoChannelUsers.class, a.f482o), Tuples.m10073to(GuildRoleSubscriptionBenefitType.class, a.f483p), Tuples.m10073to(GuildScheduledEventEntityType.class, a.f484q), Tuples.m10073to(GuildScheduledEventStatus.class, a.f485r), Tuples.m10073to(GuildVerificationLevel.class, a.f486s), Tuples.m10073to(LocalizedString.class, a.f487t), Tuples.m10073to(MessageActivityType.class, a.f488u), Tuples.m10073to(NsfwAllowance.class, a.f489v), Tuples.m10073to(OAuthScope.class, a.f490w), Tuples.m10073to(PayoutGroupStatus.class, a.f491x), Tuples.m10073to(PayoutGroupType.class, a.f492y), Tuples.m10073to(PayoutStatus.class, a.f493z), Tuples.m10073to(Phone.class, a.f456A), Tuples.m10073to(PremiumTier.class, a.f457B), Tuples.m10073to(PriceTierType.class, a.f458C), Tuples.m10073to(ReportNodeBottomButton.class, a.f460E), Tuples.m10073to(ReportNodeChild.class, a.f461F), Tuples.m10073to(ReportNodeElementData.class, a.f462G), Tuples.m10073to(RequiredAction.class, a.f463H), Tuples.m10073to(Science.Event.SchemaObject.class, a.f464I), Tuples.m10073to(StageInstancePrivacyLevel.class, a.f465J), Tuples.m10073to(StickerFormatType.class, a.f466K), Tuples.m10073to(StickerType.class, a.f467L), Tuples.m10073to(TextComponent2.class, a.f468M), Tuples.m10073to(UtcDateTime.class, a.f469N));

    /* JADX INFO: renamed from: b */
    public static final List<TypeAdapterFactory2> f455b = Collections2.listOf((Object[]) new TypeAdapterFactory2[]{ComponentRuntimeTypeAdapter.INSTANCE.m7624a(), new NullSerializable3()});

    /* JADX INFO: renamed from: b.a.b.a$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: V */
        public final /* synthetic */ int f494V;

        /* JADX INFO: renamed from: j */
        public static final a f477j = new a(0);

        /* JADX INFO: renamed from: k */
        public static final a f478k = new a(1);

        /* JADX INFO: renamed from: l */
        public static final a f479l = new a(2);

        /* JADX INFO: renamed from: m */
        public static final a f480m = new a(3);

        /* JADX INFO: renamed from: n */
        public static final a f481n = new a(4);

        /* JADX INFO: renamed from: o */
        public static final a f482o = new a(5);

        /* JADX INFO: renamed from: p */
        public static final a f483p = new a(6);

        /* JADX INFO: renamed from: q */
        public static final a f484q = new a(7);

        /* JADX INFO: renamed from: r */
        public static final a f485r = new a(8);

        /* JADX INFO: renamed from: s */
        public static final a f486s = new a(9);

        /* JADX INFO: renamed from: t */
        public static final a f487t = new a(10);

        /* JADX INFO: renamed from: u */
        public static final a f488u = new a(11);

        /* JADX INFO: renamed from: v */
        public static final a f489v = new a(12);

        /* JADX INFO: renamed from: w */
        public static final a f490w = new a(13);

        /* JADX INFO: renamed from: x */
        public static final a f491x = new a(14);

        /* JADX INFO: renamed from: y */
        public static final a f492y = new a(15);

        /* JADX INFO: renamed from: z */
        public static final a f493z = new a(16);

        /* JADX INFO: renamed from: A */
        public static final a f456A = new a(17);

        /* JADX INFO: renamed from: B */
        public static final a f457B = new a(18);

        /* JADX INFO: renamed from: C */
        public static final a f458C = new a(19);

        /* JADX INFO: renamed from: D */
        public static final a f459D = new a(20);

        /* JADX INFO: renamed from: E */
        public static final a f460E = new a(21);

        /* JADX INFO: renamed from: F */
        public static final a f461F = new a(22);

        /* JADX INFO: renamed from: G */
        public static final a f462G = new a(23);

        /* JADX INFO: renamed from: H */
        public static final a f463H = new a(24);

        /* JADX INFO: renamed from: I */
        public static final a f464I = new a(25);

        /* JADX INFO: renamed from: J */
        public static final a f465J = new a(26);

        /* JADX INFO: renamed from: K */
        public static final a f466K = new a(27);

        /* JADX INFO: renamed from: L */
        public static final a f467L = new a(28);

        /* JADX INFO: renamed from: M */
        public static final a f468M = new a(29);

        /* JADX INFO: renamed from: N */
        public static final a f469N = new a(30);

        /* JADX INFO: renamed from: O */
        public static final a f470O = new a(31);

        /* JADX INFO: renamed from: P */
        public static final a f471P = new a(32);

        /* JADX INFO: renamed from: Q */
        public static final a f472Q = new a(33);

        /* JADX INFO: renamed from: R */
        public static final a f473R = new a(34);

        /* JADX INFO: renamed from: S */
        public static final a f474S = new a(35);

        /* JADX INFO: renamed from: T */
        public static final a f475T = new a(36);

        /* JADX INFO: renamed from: U */
        public static final a f476U = new a(37);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.f494V = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.f494V) {
                case 0:
                    return new ComponentTypeTypeAdapter();
                case 1:
                    return new EmbedType3();
                case 2:
                    return new FriendSuggestionReasonType2();
                case 3:
                    return new GuildExplicitContentFilter2();
                case 4:
                    return new GuildHubType2();
                case 5:
                    return new GuildMaxVideoChannelUsers2();
                case 6:
                    return new GuildRoleSubscriptionBenefitType2();
                case 7:
                    return new GuildScheduledEventEntityType2();
                case 8:
                    return new GuildScheduledEventStatus2();
                case 9:
                    return new GuildVerificationLevel2();
                case 10:
                    return new LocalizedString2();
                case 11:
                    return new MessageActivityType2();
                case 12:
                    return new NsfwAllowance2();
                case 13:
                    return new OAuthScopeTypeAdapter();
                case 14:
                    return new PayoutGroupStatus2();
                case 15:
                    return new PayoutGroupType2();
                case 16:
                    return new PayoutStatus2();
                case 17:
                    return new Phone2();
                case 18:
                    return new PremiumTier2();
                case 19:
                    return new PriceTierType2();
                case 20:
                    return new ActivityType2();
                case 21:
                    return new ReportNodeBottomButtonTypeAdapter();
                case 22:
                    return new ReportNodeChildTypeAdapter();
                case 23:
                    return new ReportNodeElementDataTypeAdapter();
                case 24:
                    return new RequiredAction2();
                case 25:
                    return new AnalyticsSchemaTypeAdapter();
                case 26:
                    return new StageInstancePrivacyLevel2();
                case 27:
                    return new StickerFormatType2();
                case 28:
                    return new StickerType2();
                case 29:
                    return new TextComponent3();
                case 30:
                    return new UtcDateTime2();
                case 31:
                    return new ActivityType2();
                case 32:
                    return new AllowedInSuggestionsType2();
                case 33:
                    return new ApplicationCommandPermission3();
                case 34:
                    return new ApplicationCommandType2();
                case 35:
                    return new ApplicationStatus2();
                case 36:
                    return new ApplicationType2();
                case 37:
                    return new ButtonComponent3();
                default:
                    throw null;
            }
        }
    }

    /* JADX INFO: renamed from: b.a.b.a$b */
    /* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
    public static final class b extends Lambda implements Function0<ActivityPlatform2> {

        /* JADX INFO: renamed from: j */
        public static final b f495j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityPlatform2 invoke() {
            return new ActivityPlatform2();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final GsonBuilder m147a(GsonBuilder gsonBuilder) {
        Intrinsics3.checkNotNullParameter(gsonBuilder, "$this$registerDiscordApiTypeAdapters");
        for (Map.Entry<Class<? extends Object>, Function0<Object>> entry : f454a.entrySet()) {
            gsonBuilder.m6852b(entry.getKey(), entry.getValue().invoke());
        }
        Intrinsics3.checkNotNullParameter(gsonBuilder, "$this$registerDiscordApiTypeAdapterFactories");
        Iterator<T> it = f455b.iterator();
        while (it.hasNext()) {
            gsonBuilder.f13099e.add((TypeAdapterFactory2) it.next());
        }
        return gsonBuilder;
    }
}
