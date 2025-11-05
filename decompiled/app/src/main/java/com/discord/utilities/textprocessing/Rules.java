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
import b.a.t.a.c;
import b.a.t.a.f;
import b.a.t.a.h;
import b.a.t.a.i;
import b.a.t.a.j;
import b.a.t.a.k;
import b.a.t.a.l;
import b.a.t.a.o;
import b.a.t.a.p;
import b.a.t.a.q;
import b.a.t.a.r;
import b.a.t.a.t;
import b.a.t.a.v;
import b.a.t.a.w;
import b.a.t.b.b.e;
import b.a.t.c.a;
import com.discord.R;
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
import d0.g;
import d0.g0.s;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
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
    private static final Lazy PATTERN_UNICODE_EMOJI = g.lazy(Rules$PATTERN_UNICODE_EMOJI$2.INSTANCE);
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:([a-zA-Z_0-9]+):(\\d+)>");
    private static final Pattern PATTERN_NAMED_EMOJI = Pattern.compile("^:([^\\s:]+?(?:::skin-tone-\\d)?):");
    private static final Pattern PATTERN_UNESCAPE_EMOTICON = Pattern.compile("^(¯\\\\_\\(ツ\\)_/¯)");
    private static final Pattern PATTERN_TIMESTAMP = Pattern.compile("^<t:(-?\\d{1,17})(?::(t|T|d|D|f|F|R))?>");
    private static final Pattern PATTERN_URL = Pattern.compile("^(https?://[^\\s<]+[^<.,:;\"')\\]\\s])");
    private static final String LINK = "^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_MASKED_LINK = Pattern.compile(LINK);
    private static final Set<Character> PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS = n0.setOf((Object[]) new Character[]{'[', ']'});
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
    public static final class HeaderLineClassedRule<RC, T, S> extends a.C0055a<RC, Object, S> {
        private final Function0<List<Object>> headerPaddingSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HeaderLineClassedRule(Function0<? extends List<? extends Object>> function0, Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function12) {
            super(function1, function12);
            m.checkNotNullParameter(function0, "headerPaddingSpanProvider");
            m.checkNotNullParameter(function1, "styleSpanProvider");
            m.checkNotNullParameter(function12, "classSpanProvider");
            this.headerPaddingSpanProvider = function0;
        }

        @Override // b.a.t.c.a.C0055a, b.a.t.c.a.b, b.a.t.c.a.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            Node<RC> node = super.parse(matcher, parser, state).root;
            StyleNode styleNode = new StyleNode(this.headerPaddingSpanProvider.invoke());
            styleNode.addChild(node);
            m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state);
        }
    }

    /* compiled from: Rules.kt */
    public static final class MarkdownListItemRule<RC, S> extends Rule.BlockRule<RC, Node<RC>, S> {
        private final Function0<List<Object>> spansProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MarkdownListItemRule(Function0<? extends List<? extends Object>> function0) {
            super(a.a);
            m.checkNotNullParameter(function0, "spansProvider");
            a aVar = a.e;
            this.spansProvider = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(this.spansProvider.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBlockQuoteRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule.BlockRule<T, BlockQuoteNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
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
            m.checkNotNullParameter(inspectionSource, "inspectionSource");
            m.checkNotNullParameter(state, "state");
            if (state.getIsInQuote()) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, (String) state);
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser<TT;-Lcom/discord/utilities/textprocessing/node/BlockQuoteNode<TT;>;TS;>;TS;)Lcom/discord/simpleast/core/parser/ParseSpec<TT;TS;>; */
        public ParseSpec parse(Matcher matcher, Parser parser, BlockQuoteState state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            m.checkNotNullParameter(state, "state");
            int i = matcher.group(1) != null ? 1 : 2;
            BlockQuoteState blockQuoteStateNewBlockQuoteState = state.newBlockQuoteState(true);
            BlockQuoteNode blockQuoteNode = new BlockQuoteNode();
            int iStart = matcher.start(i);
            int iEnd = matcher.end(i);
            m.checkNotNullParameter(blockQuoteNode, "node");
            return new ParseSpec(blockQuoteNode, blockQuoteStateNewBlockQuoteState, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createBoldColoredRule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
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
            return n.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StyleSpan(1)});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createChannelMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, ChannelMentionNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super ChannelMentionNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            ChannelMentionNode channelMentionNode = new ChannelMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            m.checkNotNullParameter(channelMentionNode, "node");
            return new ParseSpec<>(channelMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RC, S] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1, reason: invalid class name */
    public static final class AnonymousClass1<RC, S> extends o implements Function3<CodeNode<RC>, Boolean, S, Node<RC>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: Rules.kt */
        /* renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03461 extends Node.a<RC> {
            public final /* synthetic */ CodeNode $codeNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03461(CodeNode codeNode, Node[] nodeArr) {
                super(nodeArr);
                this.$codeNode = codeNode;
            }

            @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
            public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
                render(spannableStringBuilder, (BasicRenderContext) obj);
            }

            /* JADX WARN: Incorrect types in method signature: (Landroid/text/SpannableStringBuilder;TRC;)V */
            public void render(SpannableStringBuilder builder, BasicRenderContext renderContext) {
                m.checkNotNullParameter(builder, "builder");
                m.checkNotNullParameter(renderContext, "renderContext");
                int length = builder.length();
                super.render(builder, (SpannableStringBuilder) renderContext);
                builder.setSpan(new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_code)), length, builder.length(), 33);
            }
        }

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((CodeNode) obj, bool.booleanValue(), (BlockQuoteState) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (Lcom/discord/simpleast/code/CodeNode<TRC;>;ZTS;)Lcom/discord/simpleast/core/node/Node<TRC;>; */
        public final Node invoke(CodeNode codeNode, boolean z2, BlockQuoteState blockQuoteState) {
            m.checkNotNullParameter(codeNode, "codeNode");
            m.checkNotNullParameter(blockQuoteState, "state");
            return !z2 ? new C03461(codeNode, new Node[]{codeNode}) : new BlockBackgroundNode(blockQuoteState.getIsInQuote(), codeNode);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createCustomEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, EmojiNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super EmojiNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String strGroup = matcher.group(2);
            m.checkNotNull(strGroup);
            long longOrDefault$default = Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(3), 0L, 1, null);
            EmojiNode emojiNode = new EmojiNode(strGroup, new Rules$createCustomEmojiRule$1$parse$emojiNode$1(longOrDefault$default, zIsEmpty), new EmojiNode.EmojiIdAndType.Custom(longOrDefault$default, zIsEmpty, strGroup), 0, 0, 24, null);
            m.checkNotNullParameter(emojiNode, "node");
            return new ParseSpec<>(emojiNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHeaderItemRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule.BlockRule<T, HeaderNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super HeaderNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            HeaderNode headerNode = new HeaderNode(strGroup != null ? strGroup.length() : 1);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            m.checkNotNullParameter(headerNode, "node");
            return new ParseSpec<>(headerNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createHookedLinkRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(n.emptyList());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$1, reason: invalid class name */
    public static final class AnonymousClass1<RC> implements StyleNode.a<RC> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // com.discord.simpleast.core.node.StyleNode.a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            m.checkNotNullParameter(basicRenderContext, "it");
            return n.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), R.style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createInlineCodeRule$2, reason: invalid class name */
    public static final class AnonymousClass2<RC> implements StyleNode.a<RC> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // com.discord.simpleast.core.node.StyleNode.a
        public /* bridge */ /* synthetic */ Iterable get(Object obj) {
            return get((BasicRenderContext) obj);
        }

        /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
        public final Iterable get(BasicRenderContext basicRenderContext) {
            m.checkNotNullParameter(basicRenderContext, "it");
            return d0.t.m.listOf(new BackgroundColorSpan(ColorCompat.getThemedColor(basicRenderContext.getContext(), R.attr.theme_chat_code)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createListItemRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, BulletListNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super BulletListNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            int i = strGroup == null || strGroup.length() == 0 ? 1 : 2;
            String strGroup2 = matcher.group(3);
            BulletListNode bulletListNode = new BulletListNode(i, true ^ (strGroup2 == null || strGroup2.length() == 0));
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            m.checkNotNullParameter(bulletListNode, "node");
            return new ParseSpec<>(bulletListNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createMaskedLinkRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
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
            m.checkNotNullParameter(inspectionSource, "inspectionSource");
            if (isLikelyPathologicalAttack(inspectionSource)) {
                return null;
            }
            return super.match(inspectionSource, lastCapture, state);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            String strGroup2 = matcher.group(2);
            m.checkNotNull(strGroup2);
            UrlNode urlNode = new UrlNode(strGroup2, strGroup);
            m.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createNamedEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisNamesMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                m.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            String strGroup2 = matcher.group();
            m.checkNotNullExpressionValue(strGroup2, "matcher.group()");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup2);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createRoleMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, RoleMentionNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super RoleMentionNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            RoleMentionNode roleMentionNode = new RoleMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            m.checkNotNullParameter(roleMentionNode, "node");
            return new ParseSpec<>(roleMentionNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSoftHyphenRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, b.a.t.b.a.a<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super b.a.t.b.a.a<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a("");
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createSpoilerRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, SpoilerNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super SpoilerNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            SpoilerNode spoilerNode = new SpoilerNode(strGroup);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            m.checkNotNullParameter(spoilerNode, "node");
            return new ParseSpec<>(spoilerNode, state, iStart, iEnd);
        }
    }

    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createStrikethroughColoredRule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
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
            return n.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StrikethroughSpan()});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTextReplacementRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        private final List<Rule<T, Node<T>, S>> innerRules;

        public AnonymousClass1(Pattern pattern) {
            super(pattern);
            this.innerRules = n.listOf((Object[]) new Rule[]{Rules.INSTANCE.createNamedEmojiRule(), e.h.d()});
        }

        public final List<Rule<T, Node<T>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Node node;
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            Rules rules = Rules.INSTANCE;
            String strGroup = matcher.group();
            m.checkNotNullExpressionValue(strGroup, "matcher.group()");
            List<T> list = parser.parse(Rules.access$replaceEmojiSurrogates(rules, strGroup), state, this.innerRules);
            if (list.size() == 1) {
                Object objFirst = u.first((List<? extends Object>) list);
                Objects.requireNonNull(objFirst, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                node = (Node) objFirst;
            } else {
                StyleNode styleNode = new StyleNode(n.emptyList());
                for (Object obj : list) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                    styleNode.addChild((Node) obj);
                }
                node = styleNode;
            }
            m.checkNotNullParameter(node, "node");
            return new ParseSpec<>(node, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createTimestampRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, TimestampNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TimestampNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            TimestampNode timestampNode = new TimestampNode(strGroup, matcher.group(2));
            m.checkNotNullParameter(timestampNode, "node");
            return new ParseSpec<>(timestampNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnescapeEmoticonRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, b.a.t.b.a.a<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super b.a.t.b.a.a<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUnicodeEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                m.checkNotNullParameter(emojiNodeFrom$default, "node");
                return new ParseSpec<>(emojiNodeFrom$default, state);
            }
            m.checkNotNullExpressionValue(strGroup, "match");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlNoEmbedRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            m.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUrlRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, UrlNode<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            m.checkNotNull(strGroup);
            UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
            m.checkNotNullParameter(urlNode, "node");
            return new ParseSpec<>(urlNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: Rules.kt */
    /* renamed from: com.discord.utilities.textprocessing.Rules$createUserMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public AnonymousClass1(Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            if (!TextUtils.isEmpty(matcher.group(1))) {
                UserMentionNode userMentionNode = new UserMentionNode(UserMentionNode.Type.USER, Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                m.checkNotNullParameter(userMentionNode, "node");
                return new ParseSpec<>(userMentionNode, state);
            }
            String strGroup = matcher.group(2);
            m.checkNotNull(strGroup);
            UserMentionNode userMentionNode2 = new UserMentionNode(strGroup.charAt(0) != 'e' ? UserMentionNode.Type.HERE : UserMentionNode.Type.EVERYONE, 0L, 2, null);
            m.checkNotNullParameter(userMentionNode2, "node");
            return new ParseSpec<>(userMentionNode2, state);
        }
    }

    static {
        a aVar = a.e;
        PATTERN_HEADER_ITEM = a.f309b;
    }

    private Rules() {
    }

    public static final /* synthetic */ EmojiDataProvider access$getEmojiDataProvider$p(Rules rules) {
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            m.throwUninitializedPropertyAccessException("emojiDataProvider");
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
            m.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        Matcher matcher = emojiDataProvider2.getUnicodeEmojisPattern().matcher(originalText);
        while (matcher.find()) {
            String strGroup = matcher.group();
            EmojiDataProvider emojiDataProvider3 = emojiDataProvider;
            if (emojiDataProvider3 == null) {
                m.throwUninitializedPropertyAccessException("emojiDataProvider");
            }
            ModelEmojiUnicode modelEmojiUnicode = emojiDataProvider3.getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                StringBuilder sbU = b.d.b.a.a.U(":");
                sbU.append(modelEmojiUnicode.getFirstName());
                sbU.append(":");
                matcher.appendReplacement(stringBuffer, sbU.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String string = stringBuffer.toString();
        m.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public static final void setEmojiDataProvider(EmojiDataProvider emojiDataProvider2) {
        m.checkNotNullParameter(emojiDataProvider2, "emojiDataProvider");
        emojiDataProvider = emojiDataProvider2;
    }

    private final long toLongOrDefault(String str, long j) {
        Long longOrNull;
        return (str == null || (longOrNull = s.toLongOrNull(str)) == null) ? j : longOrNull.longValue();
    }

    public static /* synthetic */ long toLongOrDefault$default(Rules rules, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return rules.toLongOrDefault(str, j);
    }

    public final <T extends BasicRenderContext, S extends BlockQuoteState<S>> Rule.BlockRule<T, BlockQuoteNode<T>, S> createBlockQuoteRule() {
        Pattern pattern = PATTERN_BLOCK_QUOTE;
        m.checkNotNullExpressionValue(pattern, "PATTERN_BLOCK_QUOTE");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createBoldColoredRule(@ColorInt int color) {
        e eVar = e.h;
        Pattern pattern = e.a;
        m.checkNotNullExpressionValue(pattern, "PATTERN_BOLD");
        return e.c(pattern, new AnonymousClass1(color));
    }

    public final <T extends ChannelMentionNode.RenderContext, S> Rule<T, ChannelMentionNode<T>, S> createChannelMentionRule() {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new AnonymousClass1(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createCodeBlockRule() {
        f fVar = new f(Rules$createCodeBlockRule$codeStyleProviders$1.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$2.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$3.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$4.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$5.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$6.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$7.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$8.INSTANCE);
        b.a.t.a.e eVar = b.a.t.a.e.f;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        b.a.t.a.o oVar = b.a.t.a.o.f;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern = b.a.t.a.o.c;
        m.checkNotNullExpressionValue(pattern, "PATTERN_KOTLIN_COMMENTS");
        Pattern pattern2 = b.a.t.a.o.e;
        m.checkNotNullExpressionValue(pattern2, "PATTERN_KOTLIN_STRINGS");
        Pattern pattern3 = b.a.t.a.o.d;
        m.checkNotNullExpressionValue(pattern3, "PATTERN_KOTLIN_ANNOTATION");
        o.a.C0052a c0052a = o.a.f299b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern4 = o.a.a;
        m.checkNotNullExpressionValue(pattern4, "PATTERN_KOTLIN_FIELD");
        o.b.a aVar = o.b.f300b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        List listB = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern2, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern3, 0, fVar.g, 1), new b.a.t.a.n(c0052a, fVar, pattern4), new p(aVar, fVar, o.b.a)}), new String[]{"object", "class", "interface"}, b.a.t.a.o.f298b, b.a.t.a.o.a, null, 32);
        Pattern patternC = eVar.c("//");
        m.checkNotNullExpressionValue(patternC, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        List listB2 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile, 0, fVar.c, 1)}), new String[]{"message|enum|extend|service"}, new String[]{"true|false", "string|bool|double|float|bytes", "int32|uint32|sint32|int64|unit64|sint64", "map"}, new String[]{"required|repeated|optional|option|oneof|default|reserved", "package|import", "rpc|returns"}, null, 32);
        Pattern patternC2 = eVar.c("#");
        m.checkNotNullExpressionValue(patternC2, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile2 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile3 = Pattern.compile("^'[\\s\\S]*?(?<!\\\\)'(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^'[\\s…*?(?<!\\\\)'(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile4 = Pattern.compile("^@(\\w+)");
        m.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^@(\\w+)\"\"\")");
        List listB3 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC2, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile2, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile3, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile4, 0, fVar.g, 1)}), new String[]{"class", "def", "lambda"}, new String[]{"True|False|None"}, new String[]{"from|import|global|nonlocal", "async|await|class|self|cls|def|lambda", "for|while|if|else|elif|break|continue|return", "try|except|finally|raise|pass|yeild", "in|as|is|del", "and|or|not|assert"}, null, 32);
        Pattern patternC3 = eVar.c("//");
        m.checkNotNullExpressionValue(patternC3, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile5 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile6 = Pattern.compile("^#!?\\[.*?\\]\\n");
        m.checkNotNullExpressionValue(patternCompile6, "Pattern.compile(\"\"\"^#!?\\[.*?\\]\\n\"\"\")");
        List listB4 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC3, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile5, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile6, 0, fVar.g, 1)}), new String[]{"struct", "trait", "mod"}, new String[]{"Self|Result|Ok|Err|Option|None|Some", "Copy|Clone|Eq|Hash|Send|Sync|Sized|Debug|Display", "Arc|Rc|Box|Pin|Future", "true|false|bool|usize|i64|u64|u32|i32|str|String"}, new String[]{"let|mut|static|const|unsafe", "crate|mod|extern|pub|pub(super)|use", "struct|enum|trait|type|where|impl|dyn|async|await|move|self|fn", "for|while|loop|if|else|match|break|continue|return|try", "in|as|ref"}, null, 32);
        v vVar = v.c;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern5 = b.a.t.a.e.c;
        Pattern pattern6 = b.a.t.a.e.d;
        List listListOf = n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, v.a, 0, fVar.f291b, 1), new w(vVar, fVar, v.f306b), b.a.t.a.e.e(eVar, pattern5, 0, null, 3), b.a.t.a.e.e(eVar, pattern6, 0, null, 3)});
        Pattern patternC4 = eVar.c("#");
        m.checkNotNullExpressionValue(patternC4, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile7 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile7, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        String strPattern = eVar.d("true|false|null").pattern();
        m.checkNotNullExpressionValue(strPattern, "createWordPattern(\"true|false|null\").pattern()");
        Pattern patternCompile8 = Pattern.compile(strPattern, 2);
        m.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        String strPattern2 = eVar.d("select|from|join|where|and|as|distinct|count|avg", "order by|group by|desc|sum|min|max", "like|having|in|is|not").pattern();
        m.checkNotNullExpressionValue(strPattern2, "createWordPattern(\n     …ing|in|is|not\").pattern()");
        Pattern patternCompile9 = Pattern.compile(strPattern2, 2);
        m.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        List listListOf2 = n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC4, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile7, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile8, 0, fVar.g, 1), b.a.t.a.e.e(eVar, patternCompile9, 0, fVar.d, 1), b.a.t.a.e.e(eVar, b.a.t.a.e.e, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern5, 0, null, 3), b.a.t.a.e.e(eVar, pattern6, 0, null, 3)});
        i iVar = i.h;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern7 = i.c;
        m.checkNotNullExpressionValue(pattern7, "PATTERN_CRYSTAL_COMMENTS");
        Pattern pattern8 = i.e;
        m.checkNotNullExpressionValue(pattern8, "PATTERN_CRYSTAL_STRINGS");
        Pattern pattern9 = i.f;
        m.checkNotNullExpressionValue(pattern9, "PATTERN_CRYSTAL_REGEX");
        Pattern pattern10 = i.d;
        m.checkNotNullExpressionValue(pattern10, "PATTERN_CRYSTAL_ANNOTATION");
        Pattern pattern11 = i.g;
        m.checkNotNullExpressionValue(pattern11, "PATTERN_CRYSTAL_SYMBOL");
        i.a.C0050a c0050a = i.a.f293b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern12 = i.a.a;
        m.checkNotNullExpressionValue(pattern12, "PATTERN_CRYSTAL_FUNC");
        List listB5 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern7, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern8, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern9, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern10, 0, fVar.g, 1), b.a.t.a.e.e(eVar, pattern11, 0, fVar.c, 1), new h(c0050a, fVar, pattern12)}), new String[]{"def", "class"}, i.f292b, i.a, null, 32);
        k kVar = k.g;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern13 = k.e;
        m.checkNotNullExpressionValue(pattern13, "PATTERN_JAVASCRIPT_COMMENTS");
        Pattern pattern14 = k.f;
        m.checkNotNullExpressionValue(pattern14, "PATTERN_JAVASCRIPT_STRINGS");
        k.c.a aVar2 = k.c.f297b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern15 = k.c.a;
        m.checkNotNullExpressionValue(pattern15, "PATTERN_JAVASCRIPT_OBJECT_PROPERTY");
        Pattern pattern16 = k.d;
        m.checkNotNullExpressionValue(pattern16, "PATTERN_JAVASCRIPT_GENERIC");
        Pattern pattern17 = k.c;
        m.checkNotNullExpressionValue(pattern17, "PATTERN_JAVASCRIPT_REGEX");
        k.a.C0051a c0051a = k.a.f295b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern18 = k.a.a;
        m.checkNotNullExpressionValue(pattern18, "PATTERN_JAVASCRIPT_FIELD");
        k.b.a aVar3 = k.b.f296b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        List listB6 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern13, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern14, 0, fVar.c, 1), new b.a.t.a.m(aVar2, fVar, pattern15), b.a.t.a.e.e(eVar, pattern16, 0, fVar.g, 1), b.a.t.a.e.e(eVar, pattern17, 0, fVar.c, 1), new j(c0051a, fVar, pattern18), new l(aVar3, fVar, k.b.a)}), new String[]{"class"}, k.f294b, k.a, null, 32);
        r rVar = r.g;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern19 = r.e;
        m.checkNotNullExpressionValue(pattern19, "PATTERN_TYPESCRIPT_COMMENTS");
        Pattern pattern20 = r.f;
        m.checkNotNullExpressionValue(pattern20, "PATTERN_TYPESCRIPT_STRINGS");
        r.d.a aVar4 = r.d.f305b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern21 = r.d.a;
        m.checkNotNullExpressionValue(pattern21, "PATTERN_TYPESCRIPT_OBJECT_PROPERTY");
        Pattern pattern22 = r.d;
        m.checkNotNullExpressionValue(pattern22, "PATTERN_TYPESCRIPT_REGEX");
        r.b.a aVar5 = r.b.f303b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern23 = r.b.a;
        m.checkNotNullExpressionValue(pattern23, "PATTERN_TYPESCRIPT_FIELD");
        r.c.a aVar6 = r.c.f304b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        r.a.C0053a c0053a = r.a.f302b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern24 = r.a.a;
        m.checkNotNullExpressionValue(pattern24, "PATTERN_TYPESCRIPT_DECORATOR");
        List listA = eVar.a(fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern19, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern20, 0, fVar.c, 1), new b.a.t.a.u(aVar4, fVar, pattern21), b.a.t.a.e.e(eVar, pattern22, 0, fVar.c, 1), new b.a.t.a.s(aVar5, fVar, pattern23), new t(aVar6, fVar, r.c.a), new q(c0053a, fVar, pattern24)}), new String[]{"class", "interface", "enum", "namespace", "module", "type"}, r.f301b, r.a, r.c);
        Map mapMapOf = h0.mapOf(d0.o.to("kt", listB), d0.o.to("kotlin", listB), d0.o.to("protobuf", listB2), d0.o.to("proto", listB2), d0.o.to("pb", listB2), d0.o.to("py", listB3), d0.o.to("python", listB3), d0.o.to("rs", listB4), d0.o.to("rust", listB4), d0.o.to("cql", listListOf2), d0.o.to("sql", listListOf2), d0.o.to("xml", listListOf), d0.o.to("http", listListOf), d0.o.to("cr", listB5), d0.o.to("crystal", listB5), d0.o.to("js", listB6), d0.o.to("javascript", listB6), d0.o.to("ts", listA), d0.o.to("typescript", listA));
        b.a.t.a.e eVar2 = b.a.t.a.e.f;
        StyleNode.a<R> aVar7 = fVar.a;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        m.checkNotNullParameter(aVar7, "textStyleProvider");
        m.checkNotNullParameter(mapMapOf, "languageMap");
        m.checkNotNullParameter(anonymousClass1, "wrapperNodeProvider");
        return new b.a.t.a.a(eVar2, mapMapOf, aVar7, anonymousClass1, b.a.t.a.e.a);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, EmojiNode<T>, S> createCustomEmojiRule() {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new AnonymousClass1(pattern);
    }

    public final <T extends BasicRenderContext, S> Rule.BlockRule<T, HeaderNode<T>, S> createHeaderItemRule() {
        return new AnonymousClass1(PATTERN_HEADER_ITEM);
    }

    public final <T, S> Rule<T, Node<T>, S> createHookedLinkRule() {
        Pattern pattern = PATTERN_HOOKED_LINK;
        m.checkNotNullExpressionValue(pattern, "PATTERN_HOOKED_LINK");
        return new AnonymousClass1(pattern);
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createInlineCodeRule() {
        b.a.t.a.e eVar = b.a.t.a.e.f;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        m.checkNotNullParameter(anonymousClass1, "textStyleProvider");
        m.checkNotNullParameter(anonymousClass2, "bgStyleProvider");
        return new c(eVar, anonymousClass1, anonymousClass2, b.a.t.a.e.f290b);
    }

    public final <T extends BasicRenderContext, S> Rule<T, BulletListNode<T>, S> createListItemRule() {
        Pattern pattern = PATTERN_LIST_ITEM;
        m.checkNotNullExpressionValue(pattern, "PATTERN_LIST_ITEM");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createMaskedLinkRule() {
        Pattern pattern = PATTERN_MASKED_LINK;
        m.checkNotNullExpressionValue(pattern, "PATTERN_MASKED_LINK");
        return new AnonymousClass1(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createNamedEmojiRule() {
        Pattern pattern = PATTERN_NAMED_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_NAMED_EMOJI");
        return new AnonymousClass1(pattern);
    }

    public final <T extends RoleMentionNode.RenderContext, S> Rule<T, RoleMentionNode<T>, S> createRoleMentionRule() {
        Pattern pattern = PATTERN_ROLE_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, b.a.t.b.a.a<T>, S> createSoftHyphenRule() {
        Pattern pattern = PATTERN_SOFT_HYPHEN;
        m.checkNotNullExpressionValue(pattern, "PATTERN_SOFT_HYPHEN");
        return new AnonymousClass1(pattern);
    }

    public final <T extends SpoilerNode.RenderContext, S> Rule<T, SpoilerNode<T>, S> createSpoilerRule() {
        Pattern pattern = PATTERN_SPOILER;
        m.checkNotNullExpressionValue(pattern, "PATTERN_SPOILER");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createStrikethroughColoredRule(@ColorInt int color) {
        e eVar = e.h;
        Pattern pattern = e.c;
        m.checkNotNullExpressionValue(pattern, "PATTERN_STRIKETHRU");
        return e.c(pattern, new AnonymousClass1(color));
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createTextReplacementRule() {
        e eVar = e.h;
        Pattern pattern = e.e;
        m.checkNotNullExpressionValue(pattern, "SimpleMarkdownRules.PATTERN_TEXT");
        return new AnonymousClass1(pattern);
    }

    public final <T extends TimestampNode.RenderContext, S> Rule<T, TimestampNode<T>, S> createTimestampRule() {
        Pattern pattern = PATTERN_TIMESTAMP;
        m.checkNotNullExpressionValue(pattern, "PATTERN_TIMESTAMP");
        return new AnonymousClass1(pattern);
    }

    public final <T, S> Rule<T, b.a.t.b.a.a<T>, S> createUnescapeEmoticonRule() {
        Pattern pattern = PATTERN_UNESCAPE_EMOTICON;
        m.checkNotNullExpressionValue(pattern, "PATTERN_UNESCAPE_EMOTICON");
        return new AnonymousClass1(pattern);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createUnicodeEmojiRule() {
        Pattern pattern_unicode_emoji = getPATTERN_UNICODE_EMOJI();
        m.checkNotNullExpressionValue(pattern_unicode_emoji, "PATTERN_UNICODE_EMOJI");
        return new AnonymousClass1(pattern_unicode_emoji);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlNoEmbedRule() {
        Pattern pattern = PATTERN_URL_NO_EMBED;
        m.checkNotNullExpressionValue(pattern, "PATTERN_URL_NO_EMBED");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlRule() {
        Pattern pattern = PATTERN_URL;
        m.checkNotNullExpressionValue(pattern, "PATTERN_URL");
        return new AnonymousClass1(pattern);
    }

    public final <T extends UserMentionNode.RenderContext, S> Rule<T, Node<T>, S> createUserMentionRule() {
        Pattern pattern = PATTERN_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_MENTION");
        return new AnonymousClass1(pattern);
    }
}
