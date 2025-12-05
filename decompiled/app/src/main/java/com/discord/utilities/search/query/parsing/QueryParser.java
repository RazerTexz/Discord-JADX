package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: QueryParser.kt */
/* loaded from: classes2.dex */
public final class QueryParser extends Parser<Context, QueryNode, Object> {
    private static final String ANY_TOKEN_REGEX = "^[\\s]*[\\S]*[\\s]*";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IN_ANSWER_REGEX = "(?:\\s*#([^ ]+))";
    private static final String USER_REGEX = "(?:\\s*([^@#:]+)#([0-9]{4}))";

    /* compiled from: QueryParser.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Rule access$getContentRule(Companion companion) {
            return companion.getContentRule();
        }

        public static final /* synthetic */ Rule access$getFromFilterRule(Companion companion, CharSequence charSequence) {
            return companion.getFromFilterRule(charSequence);
        }

        public static final /* synthetic */ Rule access$getUserRule(Companion companion) {
            return companion.getUserRule();
        }

        private final String createHasAnswerRegex(SearchStringProvider searchStringProvider) {
            HasNode2.values();
            ArrayList arrayList = new ArrayList(7);
            HasNode2[] hasNode2ArrValues = HasNode2.values();
            for (int i = 0; i < 7; i++) {
                arrayList.add(hasNode2ArrValues[i].getLocalizedInputText(searchStringProvider));
            }
            StringBuilder sb = new StringBuilder("(?:\\s*(");
            int size = arrayList.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((CharSequence) arrayList.get(i2));
                sb.append('|');
            }
            sb.append((CharSequence) arrayList.get(arrayList.size() - 1));
            sb.append("))");
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }

        private final Rule<Context, QueryNode, Object> getContentRule() {
            Pattern patternCompile = Pattern.compile(QueryParser.ANY_TOKEN_REGEX, 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "simpleTextPattern");
            return new QueryParser2(patternCompile, patternCompile);
        }

        private final Rule<Context, QueryNode, Object> getFromFilterRule(CharSequence localizedFrom) {
            Pattern patternCompile = Pattern.compile('^' + ("[\\s]*?(" + localizedFrom + "):"), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromFilterPattern");
            return new QueryParser3(localizedFrom, patternCompile, patternCompile);
        }

        private final Rule<Context, QueryNode, Object> getUserRule() {
            Pattern patternCompile = Pattern.compile("^(?:\\s*([^@#:]+)#([0-9]{4}))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new QueryParser9(patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getHasAnswerRule(SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            Pattern patternCompile = Pattern.compile('^' + createHasAnswerRegex(searchStringProvider), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasAnswerPattern");
            return new QueryParser4(searchStringProvider, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getHasFilterRule(CharSequence localizedHas) {
            Intrinsics3.checkNotNullParameter(localizedHas, "localizedHas");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedHas + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasFilterPattern");
            return new QueryParser5(localizedHas, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getInAnswerRule() {
            Pattern patternCompile = Pattern.compile("^(?:\\s*#([^ ]+))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "inAnswerPattern");
            return new QueryParser6(patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getInFilterRule(CharSequence localizedIn) {
            Intrinsics3.checkNotNullParameter(localizedIn, "localizedIn");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedIn + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new QueryParser7(localizedIn, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getMentionsFilterRule(CharSequence localizedMentions) {
            Intrinsics3.checkNotNullParameter(localizedMentions, "localizedMentions");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedMentions + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "mentionsFilterPattern");
            return new QueryParser8(localizedMentions, patternCompile, patternCompile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser(SearchStringProvider searchStringProvider) {
        super(false, 1, null);
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Companion companion = INSTANCE;
        addRule(Companion.access$getUserRule(companion)).addRule(Companion.access$getFromFilterRule(companion, searchStringProvider.getFromFilterString())).addRule(companion.getMentionsFilterRule(searchStringProvider.getMentionsFilterString())).addRule(companion.getHasFilterRule(searchStringProvider.getHasFilterString())).addRule(companion.getHasAnswerRule(searchStringProvider)).addRule(companion.getInFilterRule(searchStringProvider.getInFilterString())).addRule(companion.getInAnswerRule()).addRule(Companion.access$getContentRule(companion));
    }
}
