package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockBackgroundNode;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.BulletListNode;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.HeaderNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.TimestampNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p050t.p051a.CodeRules;
import p007b.p008a.p050t.p051a.CodeRules3;
import p007b.p008a.p050t.p051a.CodeRules5;
import p007b.p008a.p050t.p051a.CodeStyleProviders;
import p007b.p008a.p050t.p051a.Crystal;
import p007b.p008a.p050t.p051a.Crystal2;
import p007b.p008a.p050t.p051a.JavaScript;
import p007b.p008a.p050t.p051a.JavaScript2;
import p007b.p008a.p050t.p051a.JavaScript3;
import p007b.p008a.p050t.p051a.JavaScript4;
import p007b.p008a.p050t.p051a.Kotlin;
import p007b.p008a.p050t.p051a.Kotlin2;
import p007b.p008a.p050t.p051a.Kotlin3;
import p007b.p008a.p050t.p051a.TypeScript;
import p007b.p008a.p050t.p051a.TypeScript2;
import p007b.p008a.p050t.p051a.TypeScript3;
import p007b.p008a.p050t.p051a.TypeScript4;
import p007b.p008a.p050t.p051a.TypeScript5;
import p007b.p008a.p050t.p051a.Xml;
import p007b.p008a.p050t.p051a.Xml2;
import p007b.p008a.p050t.p052b.p053a.TextNode;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p007b.p008a.p050t.p056c.MarkdownRules;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: Rules.kt */
/* loaded from: classes2.dex */
public final class Rules {
    private static final Pattern PATTERN_HEADER_ITEM;
    public static final String REGEX_CUSTOM_EMOJI = "<(a)?:([a-zA-Z_0-9]+):(\\d+)>";
    private static final String REGEX_LINK_HREF_AND_TITLE = "\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*";
    private static final String REGEX_LINK_INSIDE = "(?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*";
    private static final String REGEX_URL = "(https?://[^\\s<]+[^<.,:;\"')\\]\\s])";
    private static EmojiDataProvider emojiDataProvider;
    public static final Rules INSTANCE = new Rules();
    private static final Pattern PATTERN_BLOCK_QUOTE = Pattern.compile("^(?: *>>> +(.*)| *>(?!>>) +([^\\n]*\\n?))", 32);
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&(\\d+)>");
    private static final Pattern PATTERN_MENTION = Pattern.compile("^<@!?(\\d+)>|^@(everyone|here)");

    /* renamed from: PATTERN_UNICODE_EMOJI$delegate, reason: from kotlin metadata */
    private static final Lazy PATTERN_UNICODE_EMOJI = LazyJVM.lazy(Rules$PATTERN_UNICODE_EMOJI$2.INSTANCE);
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:([a-zA-Z_0-9]+):(\\d+)>");
    private static final Pattern PATTERN_NAMED_EMOJI = Pattern.compile("^:([^\\s:]+?(?:::skin-tone-\\d)?):");
    private static final Pattern PATTERN_UNESCAPE_EMOTICON = Pattern.compile("^(¯\\\\_\\(ツ\\)_/¯)");
    private static final Pattern PATTERN_TIMESTAMP = Pattern.compile("^<t:(-?\\d{1,17})(?::(t|T|d|D|f|F|R))?>");
    private static final Pattern PATTERN_URL = Pattern.compile("^(https?://[^\\s<]+[^<.,:;\"')\\]\\s])");
    private static final String LINK = "^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_MASKED_LINK = Pattern.compile(LINK);
    private static final Set<Character> PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS = Sets5.setOf((Object[]) new Character[]{'[', ']'});
    private static final Pattern PATTERN_URL_NO_EMBED = Pattern.compile("^<(https?://[^\\s<]+[^<.,:;\"')\\]\\s])>");
    private static final Pattern PATTERN_SOFT_HYPHEN = Pattern.compile("^\\u00AD");
    private static final Pattern PATTERN_SPOILER = Pattern.compile("^\\|\\|([\\s\\S]+?)\\|\\|");
    private static final String HOOKED_LINK = "^\\$\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)?]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_HOOKED_LINK = Pattern.compile(HOOKED_LINK);
    private static final Pattern PATTERN_LIST_ITEM = Pattern.compile("^([^\\S\\r\\n]*)[*-][ \\s]?(.*)([\\n|$])?");

    /* compiled from: Rules.kt */
    public interface BlockQuoteState<Self extends BlockQuoteState<Self>> {
        /* renamed from: isInQuote */
        boolean getIsInQuote();

        Self newBlockQuoteState(boolean isInQuote);
    }

    /* compiled from: Rules.kt */
    public interface EmojiDataProvider {
        Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap();

        Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap();

        Pattern getUnicodeEmojisPattern();
    }

    /* compiled from: Rules.kt */
    public static final class HeaderLineClassedRule<RC, T, S> extends MarkdownRules.a<RC, Object, S> {
        private final Function0<List<Object>> headerPaddingSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HeaderLineClassedRule(Function0<? extends List<? extends Object>> function0, Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function12) {
            super(function1, function12);
            Intrinsics3.checkNotNullParameter(function0, "headerPaddingSpanProvider");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function12, "classSpanProvider");
            this.headerPaddingSpanProvider = function0;
        }

        @Override // p007b.p008a.p050t.p056c.MarkdownRules.a, p007b.p008a.p050t.p056c.MarkdownRules.b, p007b.p008a.p050t.p056c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Node<RC> node = super.parse(matcher, parser, state).root;
            StyleNode styleNode = new StyleNode(this.headerPaddingSpanProvider.invoke());
            styleNode.addChild(node);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state);
        }
    }

    /* compiled from: Rules.kt */
    public static final class MarkdownListItemRule<RC, S> extends Rule.BlockRule<RC, Node<RC>, S> {
        private final Function0<List<Object>> spansProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MarkdownListItemRule(Function0<? extends List<? extends Object>> function0) {
            super(MarkdownRules.f1992a);
            Intrinsics3.checkNotNullParameter(function0, "spansProvider");
            MarkdownRules markdownRules = MarkdownRules.f1996e;
            this.spansProvider = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(this.spansProvider.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBlockQuoteRule$1 */
    public static final class C69521<S, T> extends Rule.BlockRule<T, BlockQuoteNode<T>, S> {
        public C69521(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule.BlockRule, com.discord.simpleast.core.parser.Rule
        public /* bridge */ /* synthetic */ Matcher match(CharSequence charSequence, String str, Object obj) {
            return match(charSequence, str, (BlockQuoteState) obj);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public /* bridge */ /* synthetic */ ParseSpec parse(Matcher matcher, Parser parser, Object obj) {
            return parse(matcher, parser, (BlockQuoteState) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/lang/CharSequence;Ljava/lang/String;TS;)Ljava/util/regex/Matcher; */
        /* JADX WARN: Multi-variable type inference failed */
        public Matcher match(CharSequence inspectionSource, String lastCapture, BlockQuoteState state) {
            Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
            Intrinsics3.checkNotNullParameter(state, "state");
            if (state.getIsInQuote()) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, state);
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser<TT;-Lcom/discord/utilities/textprocessing/node/BlockQuoteNode<TT;>;TS;>;TS;)Lcom/discord/simpleast/core/parser/ParseSpec<TT;TS;>; */
        public ParseSpec parse(Matcher matcher, Parser parser, BlockQuoteState state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Intrinsics3.checkNotNullParameter(state, "state");
            int i = matcher.group(1) != null ? 1 : 2;
            BlockQuoteState blockQuoteStateNewBlockQuoteState = state.newBlockQuoteState(true);
            BlockQuoteNode blockQuoteNode = new BlockQuoteNode();
            int iStart = matcher.start(i);
            int iEnd = matcher.end(i);
            Intrinsics3.checkNotNullParameter(blockQuoteNode, "node");
            return new ParseSpec(blockQuoteNode, blockQuoteStateNewBlockQuoteState, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBoldColoredRule$1 */
    public static final class C69531 extends Lambda implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69531(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends CharacterStyle> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends CharacterStyle> invoke2() {
            return Collections2.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StyleSpan(1)});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createChannelMentionRule$1 */
    public static final class C69541<S, T> extends Rule<T, ChannelMentionNode<T>, S> {
        public C69541(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super ChannelMentionNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            ChannelMentionNode channelMentionNode = new ChannelMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            Intrinsics3.checkNotNullParameter(channelMentionNode, "node");
            return new ParseSpec<>(channelMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RC, S] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1 */
    public static final class C69551<RC, S> extends Lambda implements Function3<CodeNode<RC>, Boolean, S, Node<RC>> {
        public static final C69551 INSTANCE = new C69551();

        /* compiled from: Rules.kt */
        /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Node.C5655a<RC> {
            public final /* synthetic */ CodeNode $codeNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(CodeNode codeNode, Node[] nodeArr) {
                super(nodeArr);
                this.$codeNode = codeNode;
            }

            @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
            public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
                render(spannableStringBuilder, (BasicRenderContext) obj);
            }

            /* JADX WARN: Incorrect types in method signature: (Landroid/text/SpannableStringBuilder;TRC;)V */
            public void render(SpannableStringBuilder builder, BasicRenderContext renderContext) {
                Intrinsics3.checkNotNullParameter(builder, "builder");
                Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
                int length = builder.length();
                super.render(builder, renderContext);
                builder.setSpan(new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_code)), length, builder.length(), 33);
            }
        }

        public C69551() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((CodeNode) obj, bool.booleanValue(), (BlockQuoteState) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (Lcom/discord/simpleast/code/CodeNode<TRC;>;ZTS;)Lcom/discord/simpleast/core/node/Node<TRC;>; */
        public final Node invoke(CodeNode codeNode, boolean z2, BlockQuoteState blockQuoteState) {
            Intrinsics3.checkNotNullParameter(codeNode, "codeNode");
            Intrinsics3.checkNotNullParameter(blockQuoteState, "state");
            return !z2 ? new AnonymousClass1(codeNode, new Node[]{codeNode}) : new BlockBackgroundNode(blockQuoteState.getIsInQuote(), codeNode);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCustomEmojiRule$1 */
    public static final class C69561<S, T> extends Rule<T, EmojiNode<T>, S> {
        public C69561(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super EmojiNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String strGroup = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup);
            long longOrDefault$default = Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(3), 0L, 1, null);
            EmojiNode emojiNode = new EmojiNode(strGroup, new Rules$createCustomEmojiRule$1$parse$emojiNode$1(longOrDefault$default, zIsEmpty), new EmojiNode.EmojiIdAndType.Custom(longOrDefault$default, zIsEmpty, strGroup), 0, 0, 24, null);
            Intrinsics3.checkNotNullParameter(emojiNode, "node");
            return new ParseSpec<>(emojiNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHeaderItemRule$1 */
    public static final class C69571<S, T> extends Rule.BlockRule<T, HeaderNode<T>, S> {
        public C69571(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super HeaderNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            HeaderNode headerNode = new HeaderNode(strGroup != null ? strGroup.length() : 1);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(headerNode, "node");
            return new ParseSpec<>(headerNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHookedLinkRule$1 */
    public static final class C69581<S, T> extends Rule<T, Node<T>, S> {
        public C69581(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(Collections2.emptyList());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$1 */
    public static final class C69591<RC> implements StyleNode.InterfaceC5656a<RC> {
        public static final C69591 INSTANCE = new C69591();

        @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
            return Collections2.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$2 */
    public static final class C69602<RC> implements StyleNode.InterfaceC5656a<RC> {
        public static final C69602 INSTANCE = new C69602();

        @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
            return CollectionsJVM.listOf(new BackgroundColorSpan(ColorCompat.getThemedColor(basicRenderContext.getContext(), C5419R.attr.theme_chat_code)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createListItemRule$1 */
    public static final class C69611<S, T> extends Rule<T, BulletListNode<T>, S> {
        public C69611(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super BulletListNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            int i = strGroup == null || strGroup.length() == 0 ? 1 : 2;
            String strGroup2 = matcher.group(3);
            BulletListNode bulletListNode = new BulletListNode(i, true ^ (strGroup2 == null || strGroup2.length() == 0));
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(bulletListNode, "node");
            return new ParseSpec<>(bulletListNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createMaskedLinkRule$1 */
    public static final class C69621<S, T> extends Rule<T, UrlNode<T>, S> {
        public C69621(Pattern pattern) {
            super(pattern);
        }

        private final boolean isLikelyPathologicalAttack(CharSequence source) {
            if (source.length() < 30) {
                return false;
            }
            double length = source.length() * 0.3d;
            int length2 = source.length();
            int i = 0;
            for (int i2 = 0; i2 < length2; i2++) {
                if (Rules.access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules.INSTANCE).contains(Character.valueOf(source.charAt(i2)))) {
                    i++;
                    if (i > length) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
            Intrinsics3.checkNotNullParameter(inspectionSource, "inspectionSource");
            if (isLikelyPathologicalAttack(inspectionSource)) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, state);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            String strGroup2 = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup2);
            UrlNode urlNode = new UrlNode(strGroup2, strGroup);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createNamedEmojiRule$1 */
    public static final class C69631<S, T> extends Rule<T, Node<T>, S> {
        public C69631(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisNamesMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                Intrinsics3.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            String strGroup2 = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup2, "matcher.group()");
            TextNode textNode = new TextNode(strGroup2);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createRoleMentionRule$1 */
    public static final class C69641<S, T> extends Rule<T, RoleMentionNode<T>, S> {
        public C69641(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super RoleMentionNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            RoleMentionNode roleMentionNode = new RoleMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            Intrinsics3.checkNotNullParameter(roleMentionNode, "node");
            return new ParseSpec<>(roleMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSoftHyphenRule$1 */
    public static final class C69651<S, T> extends Rule<T, TextNode<T>, S> {
        public C69651(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TextNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            TextNode textNode = new TextNode("");
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSpoilerRule$1 */
    public static final class C69661<S, T> extends Rule<T, SpoilerNode<T>, S> {
        public C69661(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super SpoilerNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            SpoilerNode spoilerNode = new SpoilerNode(strGroup);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(spoilerNode, "node");
            return new ParseSpec<>(spoilerNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createStrikethroughColoredRule$1 */
    public static final class C69671 extends Lambda implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69671(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends CharacterStyle> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends CharacterStyle> invoke2() {
            return Collections2.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StrikethroughSpan()});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTextReplacementRule$1 */
    public static final class C69681<S, T> extends Rule<T, Node<T>, S> {
        private final List<Rule<T, Node<T>, S>> innerRules;

        public C69681(Pattern pattern) {
            super(pattern);
            this.innerRules = Collections2.listOf((Object[]) new Rule[]{Rules.INSTANCE.createNamedEmojiRule(), SimpleMarkdownRules5.f1988h.m374d()});
        }

        public final List<Rule<T, Node<T>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Node node;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Rules rules = Rules.INSTANCE;
            String strGroup = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
            List<T> list = parser.parse(Rules.access$replaceEmojiSurrogates(rules, strGroup), state, this.innerRules);
            if (list.size() == 1) {
                Object objFirst = _Collections.first((List<? extends Object>) list);
                Objects.requireNonNull(objFirst, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                node = (Node) objFirst;
            } else {
                StyleNode styleNode = new StyleNode(Collections2.emptyList());
                for (Object obj : list) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                    styleNode.addChild((Node) obj);
                }
                node = styleNode;
            }
            Intrinsics3.checkNotNullParameter(node, "node");
            return new ParseSpec<>(node, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTimestampRule$1 */
    public static final class C69691<S, T> extends Rule<T, TimestampNode<T>, S> {
        public C69691(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TimestampNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            TimestampNode timestampNode = new TimestampNode(strGroup, matcher.group(2));
            Intrinsics3.checkNotNullParameter(timestampNode, "node");
            return new ParseSpec<>(timestampNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnescapeEmoticonRule$1 */
    public static final class C69701<S, T> extends Rule<T, TextNode<T>, S> {
        public C69701(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TextNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnicodeEmojiRule$1 */
    public static final class C69711<S, T> extends Rule<T, Node<T>, S> {
        public C69711(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                Intrinsics3.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "match");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlNoEmbedRule$1 */
    public static final class C69721<S, T> extends Rule<T, UrlNode<T>, S> {
        public C69721(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlRule$1 */
    public static final class C69731<S, T> extends Rule<T, UrlNode<T>, S> {
        public C69731(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            Intrinsics3.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUserMentionRule$1 */
    public static final class C69741<S, T> extends Rule<T, Node<T>, S> {
        public C69741(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            if (!TextUtils.isEmpty(matcher.group(1))) {
                UserMentionNode userMentionNode = new UserMentionNode(UserMentionNode.Type.USER, Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                Intrinsics3.checkNotNullParameter(userMentionNode, "node");
                return new ParseSpec<>(userMentionNode, state);
            }
            String strGroup = matcher.group(2);
            Intrinsics3.checkNotNull(strGroup);
            UserMentionNode userMentionNode2 = new UserMentionNode(strGroup.charAt(0) != 'e' ? UserMentionNode.Type.HERE : UserMentionNode.Type.EVERYONE, 0L, 2, null);
            Intrinsics3.checkNotNullParameter(userMentionNode2, "node");
            return new ParseSpec<>(userMentionNode2, state);
        }
    }

    static {
        MarkdownRules markdownRules = MarkdownRules.f1996e;
        PATTERN_HEADER_ITEM = MarkdownRules.f1993b;
    }

    private Rules() {
    }

    public static final /* synthetic */ EmojiDataProvider access$getEmojiDataProvider$p(Rules rules) {
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        return emojiDataProvider2;
    }

    public static final /* synthetic */ Set access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules rules) {
        return PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS;
    }

    public static final /* synthetic */ String access$replaceEmojiSurrogates(Rules rules, String str) {
        return rules.replaceEmojiSurrogates(str);
    }

    public static final /* synthetic */ void access$setEmojiDataProvider$p(Rules rules, EmojiDataProvider emojiDataProvider2) {
        emojiDataProvider = emojiDataProvider2;
    }

    private final Pattern getPATTERN_UNICODE_EMOJI() {
        return (Pattern) PATTERN_UNICODE_EMOJI.getValue();
    }

    private final String replaceEmojiSurrogates(String originalText) {
        StringBuffer stringBuffer = new StringBuffer();
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        Matcher matcher = emojiDataProvider2.getUnicodeEmojisPattern().matcher(originalText);
        while (matcher.find()) {
            String strGroup = matcher.group();
            EmojiDataProvider emojiDataProvider3 = emojiDataProvider;
            if (emojiDataProvider3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("emojiDataProvider");
            }
            ModelEmojiUnicode modelEmojiUnicode = emojiDataProvider3.getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                StringBuilder sbM833U = outline.m833U(":");
                sbM833U.append(modelEmojiUnicode.getFirstName());
                sbM833U.append(":");
                matcher.appendReplacement(stringBuffer, sbM833U.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String string = stringBuffer.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public static final void setEmojiDataProvider(EmojiDataProvider emojiDataProvider2) {
        Intrinsics3.checkNotNullParameter(emojiDataProvider2, "emojiDataProvider");
        emojiDataProvider = emojiDataProvider2;
    }

    private final long toLongOrDefault(String str, long j) {
        Long longOrNull;
        return (str == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? j : longOrNull.longValue();
    }

    public static /* synthetic */ long toLongOrDefault$default(Rules rules, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return rules.toLongOrDefault(str, j);
    }

    public final <T extends BasicRenderContext, S extends BlockQuoteState<S>> Rule.BlockRule<T, BlockQuoteNode<T>, S> createBlockQuoteRule() {
        Pattern pattern = PATTERN_BLOCK_QUOTE;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BLOCK_QUOTE");
        return new C69521(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createBoldColoredRule(@ColorInt int color) {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.f1988h;
        Pattern pattern = SimpleMarkdownRules5.f1981a;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BOLD");
        return SimpleMarkdownRules5.m373c(pattern, new C69531(color));
    }

    public final <T extends ChannelMentionNode.RenderContext, S> Rule<T, ChannelMentionNode<T>, S> createChannelMentionRule() {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new C69541(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createCodeBlockRule() {
        CodeStyleProviders codeStyleProviders = new CodeStyleProviders(Rules$createCodeBlockRule$codeStyleProviders$1.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$2.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$3.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$4.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$5.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$6.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$7.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$8.INSTANCE);
        CodeRules5 codeRules5 = CodeRules5.f1905f;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Kotlin2 kotlin2 = Kotlin2.f1948f;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern = Kotlin2.f1945c;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_KOTLIN_COMMENTS");
        Pattern pattern2 = Kotlin2.f1947e;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_KOTLIN_STRINGS");
        Pattern pattern3 = Kotlin2.f1946d;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_KOTLIN_ANNOTATION");
        Kotlin2.a.C13215a c13215a = Kotlin2.a.f1950b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern4 = Kotlin2.a.f1949a;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "PATTERN_KOTLIN_FIELD");
        Kotlin2.b.a aVar = Kotlin2.b.f1952b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        List listM366b = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, pattern, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, pattern2, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, pattern3, 0, codeStyleProviders.f1912g, 1), new Kotlin(c13215a, codeStyleProviders, pattern4), new Kotlin3(aVar, codeStyleProviders, Kotlin2.b.f1951a)}), new String[]{"object", "class", "interface"}, Kotlin2.f1944b, Kotlin2.f1943a, null, 32);
        Pattern patternM369c = codeRules5.m369c("//");
        Intrinsics3.checkNotNullExpressionValue(patternM369c, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        List listM366b2 = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, patternM369c, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, patternCompile, 0, codeStyleProviders.f1908c, 1)}), new String[]{"message|enum|extend|service"}, new String[]{"true|false", "string|bool|double|float|bytes", "int32|uint32|sint32|int64|unit64|sint64", "map"}, new String[]{"required|repeated|optional|option|oneof|default|reserved", "package|import", "rpc|returns"}, null, 32);
        Pattern patternM369c2 = codeRules5.m369c("#");
        Intrinsics3.checkNotNullExpressionValue(patternM369c2, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile2 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile3 = Pattern.compile("^'[\\s\\S]*?(?<!\\\\)'(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^'[\\s…*?(?<!\\\\)'(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile4 = Pattern.compile("^@(\\w+)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^@(\\w+)\"\"\")");
        List listM366b3 = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, patternM369c2, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, patternCompile2, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, patternCompile3, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, patternCompile4, 0, codeStyleProviders.f1912g, 1)}), new String[]{"class", "def", "lambda"}, new String[]{"True|False|None"}, new String[]{"from|import|global|nonlocal", "async|await|class|self|cls|def|lambda", "for|while|if|else|elif|break|continue|return", "try|except|finally|raise|pass|yeild", "in|as|is|del", "and|or|not|assert"}, null, 32);
        Pattern patternM369c3 = codeRules5.m369c("//");
        Intrinsics3.checkNotNullExpressionValue(patternM369c3, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile5 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile6 = Pattern.compile("^#!?\\[.*?\\]\\n");
        Intrinsics3.checkNotNullExpressionValue(patternCompile6, "Pattern.compile(\"\"\"^#!?\\[.*?\\]\\n\"\"\")");
        List listM366b4 = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, patternM369c3, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, patternCompile5, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, patternCompile6, 0, codeStyleProviders.f1912g, 1)}), new String[]{"struct", "trait", "mod"}, new String[]{"Self|Result|Ok|Err|Option|None|Some", "Copy|Clone|Eq|Hash|Send|Sync|Sized|Debug|Display", "Arc|Rc|Box|Pin|Future", "true|false|bool|usize|i64|u64|u32|i32|str|String"}, new String[]{"let|mut|static|const|unsafe", "crate|mod|extern|pub|pub(super)|use", "struct|enum|trait|type|where|impl|dyn|async|await|move|self|fn", "for|while|loop|if|else|match|break|continue|return|try", "in|as|ref"}, null, 32);
        Xml xml = Xml.f1975c;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern5 = CodeRules5.f1902c;
        Pattern pattern6 = CodeRules5.f1903d;
        List listListOf = Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, Xml.f1973a, 0, codeStyleProviders.f1907b, 1), new Xml2(xml, codeStyleProviders, Xml.f1974b), CodeRules5.m367e(codeRules5, pattern5, 0, null, 3), CodeRules5.m367e(codeRules5, pattern6, 0, null, 3)});
        Pattern patternM369c4 = codeRules5.m369c("#");
        Intrinsics3.checkNotNullExpressionValue(patternM369c4, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile7 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile7, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        String strPattern = codeRules5.m370d("true|false|null").pattern();
        Intrinsics3.checkNotNullExpressionValue(strPattern, "createWordPattern(\"true|false|null\").pattern()");
        Pattern patternCompile8 = Pattern.compile(strPattern, 2);
        Intrinsics3.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        String strPattern2 = codeRules5.m370d("select|from|join|where|and|as|distinct|count|avg", "order by|group by|desc|sum|min|max", "like|having|in|is|not").pattern();
        Intrinsics3.checkNotNullExpressionValue(strPattern2, "createWordPattern(\n     …ing|in|is|not\").pattern()");
        Pattern patternCompile9 = Pattern.compile(strPattern2, 2);
        Intrinsics3.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        List listListOf2 = Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, patternM369c4, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, patternCompile7, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, patternCompile8, 0, codeStyleProviders.f1912g, 1), CodeRules5.m367e(codeRules5, patternCompile9, 0, codeStyleProviders.f1909d, 1), CodeRules5.m367e(codeRules5, CodeRules5.f1904e, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, pattern5, 0, null, 3), CodeRules5.m367e(codeRules5, pattern6, 0, null, 3)});
        Crystal2 crystal2 = Crystal2.f1923h;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern7 = Crystal2.f1918c;
        Intrinsics3.checkNotNullExpressionValue(pattern7, "PATTERN_CRYSTAL_COMMENTS");
        Pattern pattern8 = Crystal2.f1920e;
        Intrinsics3.checkNotNullExpressionValue(pattern8, "PATTERN_CRYSTAL_STRINGS");
        Pattern pattern9 = Crystal2.f1921f;
        Intrinsics3.checkNotNullExpressionValue(pattern9, "PATTERN_CRYSTAL_REGEX");
        Pattern pattern10 = Crystal2.f1919d;
        Intrinsics3.checkNotNullExpressionValue(pattern10, "PATTERN_CRYSTAL_ANNOTATION");
        Pattern pattern11 = Crystal2.f1922g;
        Intrinsics3.checkNotNullExpressionValue(pattern11, "PATTERN_CRYSTAL_SYMBOL");
        Crystal2.a.C13213a c13213a = Crystal2.a.f1925b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern12 = Crystal2.a.f1924a;
        Intrinsics3.checkNotNullExpressionValue(pattern12, "PATTERN_CRYSTAL_FUNC");
        List listM366b5 = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, pattern7, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, pattern8, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, pattern9, 0, codeStyleProviders.f1908c, 1), CodeRules5.m367e(codeRules5, pattern10, 0, codeStyleProviders.f1912g, 1), CodeRules5.m367e(codeRules5, pattern11, 0, codeStyleProviders.f1908c, 1), new Crystal(c13213a, codeStyleProviders, pattern12)}), new String[]{"def", "class"}, Crystal2.f1917b, Crystal2.f1916a, null, 32);
        JavaScript2 javaScript2 = JavaScript2.f1933g;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern13 = JavaScript2.f1931e;
        Intrinsics3.checkNotNullExpressionValue(pattern13, "PATTERN_JAVASCRIPT_COMMENTS");
        Pattern pattern14 = JavaScript2.f1932f;
        Intrinsics3.checkNotNullExpressionValue(pattern14, "PATTERN_JAVASCRIPT_STRINGS");
        JavaScript2.c.a aVar2 = JavaScript2.c.f1939b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern15 = JavaScript2.c.f1938a;
        Intrinsics3.checkNotNullExpressionValue(pattern15, "PATTERN_JAVASCRIPT_OBJECT_PROPERTY");
        Pattern pattern16 = JavaScript2.f1930d;
        Intrinsics3.checkNotNullExpressionValue(pattern16, "PATTERN_JAVASCRIPT_GENERIC");
        Pattern pattern17 = JavaScript2.f1929c;
        Intrinsics3.checkNotNullExpressionValue(pattern17, "PATTERN_JAVASCRIPT_REGEX");
        JavaScript2.a.C13214a c13214a = JavaScript2.a.f1935b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern18 = JavaScript2.a.f1934a;
        Intrinsics3.checkNotNullExpressionValue(pattern18, "PATTERN_JAVASCRIPT_FIELD");
        JavaScript2.b.a aVar3 = JavaScript2.b.f1937b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        List listM366b6 = CodeRules5.m366b(codeRules5, codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, pattern13, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, pattern14, 0, codeStyleProviders.f1908c, 1), new JavaScript4(aVar2, codeStyleProviders, pattern15), CodeRules5.m367e(codeRules5, pattern16, 0, codeStyleProviders.f1912g, 1), CodeRules5.m367e(codeRules5, pattern17, 0, codeStyleProviders.f1908c, 1), new JavaScript(c13214a, codeStyleProviders, pattern18), new JavaScript3(aVar3, codeStyleProviders, JavaScript2.b.f1936a)}), new String[]{"class"}, JavaScript2.f1928b, JavaScript2.f1927a, null, 32);
        TypeScript2 typeScript2 = TypeScript2.f1961g;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern19 = TypeScript2.f1959e;
        Intrinsics3.checkNotNullExpressionValue(pattern19, "PATTERN_TYPESCRIPT_COMMENTS");
        Pattern pattern20 = TypeScript2.f1960f;
        Intrinsics3.checkNotNullExpressionValue(pattern20, "PATTERN_TYPESCRIPT_STRINGS");
        TypeScript2.d.a aVar4 = TypeScript2.d.f1969b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern21 = TypeScript2.d.f1968a;
        Intrinsics3.checkNotNullExpressionValue(pattern21, "PATTERN_TYPESCRIPT_OBJECT_PROPERTY");
        Pattern pattern22 = TypeScript2.f1958d;
        Intrinsics3.checkNotNullExpressionValue(pattern22, "PATTERN_TYPESCRIPT_REGEX");
        TypeScript2.b.a aVar5 = TypeScript2.b.f1965b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern23 = TypeScript2.b.f1964a;
        Intrinsics3.checkNotNullExpressionValue(pattern23, "PATTERN_TYPESCRIPT_FIELD");
        TypeScript2.c.a aVar6 = TypeScript2.c.f1967b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        TypeScript2.a.C13216a c13216a = TypeScript2.a.f1963b;
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Pattern pattern24 = TypeScript2.a.f1962a;
        Intrinsics3.checkNotNullExpressionValue(pattern24, "PATTERN_TYPESCRIPT_DECORATOR");
        List listM368a = codeRules5.m368a(codeStyleProviders, Collections2.listOf((Object[]) new Rule[]{CodeRules5.m367e(codeRules5, pattern19, 0, codeStyleProviders.f1907b, 1), CodeRules5.m367e(codeRules5, pattern20, 0, codeStyleProviders.f1908c, 1), new TypeScript5(aVar4, codeStyleProviders, pattern21), CodeRules5.m367e(codeRules5, pattern22, 0, codeStyleProviders.f1908c, 1), new TypeScript3(aVar5, codeStyleProviders, pattern23), new TypeScript4(aVar6, codeStyleProviders, TypeScript2.c.f1966a), new TypeScript(c13216a, codeStyleProviders, pattern24)}), new String[]{"class", "interface", "enum", "namespace", "module", "type"}, TypeScript2.f1956b, TypeScript2.f1955a, TypeScript2.f1957c);
        Map mapMapOf = Maps6.mapOf(Tuples.m10073to("kt", listM366b), Tuples.m10073to("kotlin", listM366b), Tuples.m10073to("protobuf", listM366b2), Tuples.m10073to("proto", listM366b2), Tuples.m10073to("pb", listM366b2), Tuples.m10073to("py", listM366b3), Tuples.m10073to("python", listM366b3), Tuples.m10073to("rs", listM366b4), Tuples.m10073to("rust", listM366b4), Tuples.m10073to("cql", listListOf2), Tuples.m10073to("sql", listListOf2), Tuples.m10073to("xml", listListOf), Tuples.m10073to("http", listListOf), Tuples.m10073to("cr", listM366b5), Tuples.m10073to("crystal", listM366b5), Tuples.m10073to("js", listM366b6), Tuples.m10073to("javascript", listM366b6), Tuples.m10073to("ts", listM368a), Tuples.m10073to("typescript", listM368a));
        CodeRules5 codeRules52 = CodeRules5.f1905f;
        StyleNode.InterfaceC5656a<R> interfaceC5656a = codeStyleProviders.f1906a;
        C69551 c69551 = C69551.INSTANCE;
        Intrinsics3.checkNotNullParameter(interfaceC5656a, "textStyleProvider");
        Intrinsics3.checkNotNullParameter(mapMapOf, "languageMap");
        Intrinsics3.checkNotNullParameter(c69551, "wrapperNodeProvider");
        return new CodeRules(codeRules52, mapMapOf, interfaceC5656a, c69551, CodeRules5.f1900a);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, EmojiNode<T>, S> createCustomEmojiRule() {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new C69561(pattern);
    }

    public final <T extends BasicRenderContext, S> Rule.BlockRule<T, HeaderNode<T>, S> createHeaderItemRule() {
        return new C69571(PATTERN_HEADER_ITEM);
    }

    public final <T, S> Rule<T, Node<T>, S> createHookedLinkRule() {
        Pattern pattern = PATTERN_HOOKED_LINK;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_HOOKED_LINK");
        return new C69581(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createInlineCodeRule() {
        CodeRules5 codeRules5 = CodeRules5.f1905f;
        C69591 c69591 = C69591.INSTANCE;
        C69602 c69602 = C69602.INSTANCE;
        Intrinsics3.checkNotNullParameter(c69591, "textStyleProvider");
        Intrinsics3.checkNotNullParameter(c69602, "bgStyleProvider");
        return new CodeRules3(codeRules5, c69591, c69602, CodeRules5.f1901b);
    }

    public final <T extends BasicRenderContext, S> Rule<T, BulletListNode<T>, S> createListItemRule() {
        Pattern pattern = PATTERN_LIST_ITEM;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_LIST_ITEM");
        return new C69611(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createMaskedLinkRule() {
        Pattern pattern = PATTERN_MASKED_LINK;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_MASKED_LINK");
        return new C69621(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createNamedEmojiRule() {
        Pattern pattern = PATTERN_NAMED_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_NAMED_EMOJI");
        return new C69631(pattern);
    }

    public final <T extends RoleMentionNode.RenderContext, S> Rule<T, RoleMentionNode<T>, S> createRoleMentionRule() {
        Pattern pattern = PATTERN_ROLE_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new C69641(pattern);
    }

    public final <T, S> Rule<T, TextNode<T>, S> createSoftHyphenRule() {
        Pattern pattern = PATTERN_SOFT_HYPHEN;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_SOFT_HYPHEN");
        return new C69651(pattern);
    }

    public final <T extends SpoilerNode.RenderContext, S> Rule<T, SpoilerNode<T>, S> createSpoilerRule() {
        Pattern pattern = PATTERN_SPOILER;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_SPOILER");
        return new C69661(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createStrikethroughColoredRule(@ColorInt int color) {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.f1988h;
        Pattern pattern = SimpleMarkdownRules5.f1983c;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_STRIKETHRU");
        return SimpleMarkdownRules5.m373c(pattern, new C69671(color));
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createTextReplacementRule() {
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.f1988h;
        Pattern pattern = SimpleMarkdownRules5.f1985e;
        Intrinsics3.checkNotNullExpressionValue(pattern, "SimpleMarkdownRules.PATTERN_TEXT");
        return new C69681(pattern);
    }

    public final <T extends TimestampNode.RenderContext, S> Rule<T, TimestampNode<T>, S> createTimestampRule() {
        Pattern pattern = PATTERN_TIMESTAMP;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_TIMESTAMP");
        return new C69691(pattern);
    }

    public final <T, S> Rule<T, TextNode<T>, S> createUnescapeEmoticonRule() {
        Pattern pattern = PATTERN_UNESCAPE_EMOTICON;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_UNESCAPE_EMOTICON");
        return new C69701(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createUnicodeEmojiRule() {
        Pattern pattern_unicode_emoji = getPATTERN_UNICODE_EMOJI();
        Intrinsics3.checkNotNullExpressionValue(pattern_unicode_emoji, "PATTERN_UNICODE_EMOJI");
        return new C69711(pattern_unicode_emoji);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlNoEmbedRule() {
        Pattern pattern = PATTERN_URL_NO_EMBED;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_URL_NO_EMBED");
        return new C69721(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlRule() {
        Pattern pattern = PATTERN_URL;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_URL");
        return new C69731(pattern);
    }

    public final <T extends UserMentionNode.RenderContext, S> Rule<T, Node<T>, S> createUserMentionRule() {
        Pattern pattern = PATTERN_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_MENTION");
        return new C69741(pattern);
    }
}
