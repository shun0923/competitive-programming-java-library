---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/LcpArray.java
    title: library/LcpArray.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/LcpArray_test.java
    title: library/LcpArray_test.java
  - icon: ':heavy_check_mark:'
    path: library/SuffixArray_test.java
    title: library/SuffixArray_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\n\nfinal class SuffixArray {\n\tpublic static final int[]\
    \ cal(String s) { return cal(s.toCharArray()); } // O(|S|)\n\tpublic static final\
    \ int[] cal(char[] c) {\n\t\tint a[] = SimpleUtil.charToInt(c);\n\t\tint max =\
    \ 0;\n\t\tfor(int ele : a) if(max < ele) max = ele;\n\t\treturn sais(a, max);\n\
    \t} // O(|S|)\n\tpublic static final int[] cal(int[] a, int max) { return sais(a,\
    \ max); } // O(|S|+M)\n\tpublic static final int[] cal(int[] a) { // O(NlogN)\n\
    \t\tint n = a.length;\n\t\tInteger[] idx = new Integer[n];\n\t\tfor(int i = 0;\
    \ i < n; i++) idx[i] = i;\n\t\tArrays.sort(idx, (l, r) -> Integer.compare(a[l],\
    \ a[r]));\n\t\tint[] a2 = new int[n];\n\t\tint crt = 0;\n\t\ta2[0] = 0;\n\t\t\
    for(int i = 1; i < n; i ++) {\n\t\t\tif(a[idx[i - 1]] != a[idx[i]]) crt ++;\n\t\
    \t\ta2[idx[i]] = crt;\n\t\t}\n\t\treturn sais(a2, crt);\n\t}\n\n\tpublic static\
    \ final int[] sais(int[] s, int max) { // O(|S|+M)\n\t\tSimpleUtil.nonNegativeCheck(max);\n\
    \t\tint n = s.length;\n\t\tif(n == 0) return new int[0];\n\t\tif(n == 1) return\
    \ new int[]{0};\n\t\tif(n == 2) {\n\t\t\tif(s[0] < s[1]) {\n\t\t\t\treturn new\
    \ int[]{0, 1};\n\t\t\t}else {\n\t\t\t\treturn new int[]{1, 0};\n\t\t\t}\n\t\t\
    }\n\n\t\tint sa[] = new int[n];\n\t\tboolean ls[] = new boolean[n];\n\t\tfor(int\
    \ i = n - 2; i >= 0; i --) ls[i] = s[i] == s[i + 1] ? ls[i + 1] : s[i] < s[i +\
    \ 1];\n\n\t\tint sumL[] = new int[max + 1];\n\t\tint sumS[] = new int[max + 1];\n\
    \n\t\tfor(int i = 0; i < n; i ++) {\n\t\t\tif(ls[i]) sumL[s[i] + 1]++;\n\t\t\t\
    else sumS[s[i]]++;\n\t\t}\n\n\t\tfor(int i = 0; i <= max; i ++) {\n\t\t\tsumS[i]\
    \ += sumL[i];\n\t\t\tif(i < max) sumL[i + 1] += sumS[i];\n\t\t}\n\n\t\tConsumer<int[]>\
    \ induce = lms -> {\n\t\t\tArrays.fill(sa, -1);\n\t\t\tint[] buf = new int[max\
    \ + 1];\n\t\t\tfor(int i = 0; i < max + 1; i ++) buf[i] = sumS[i];\n\t\t\tfor(int\
    \ d : lms) {\n\t\t\t\tif(d == n) continue;\n\t\t\t\tsa[buf[s[d]]++] = d;\n\t\t\
    \t}\n\t\t\tfor(int i = 0; i < max + 1; i ++) buf[i] = sumL[i];\n\t\t\tsa[buf[s[n\
    \ - 1]] ++] = n - 1;\n\t\t\tfor(int i = 0; i < n; i++) {\n\t\t\t\tint v = sa[i];\n\
    \t\t\t\tif(v >= 1 && !ls[v - 1]) sa[buf[s[v - 1]]++] = v - 1;\n\t\t\t}\n\t\t\t\
    for(int i = 0; i < max + 1; i ++) buf[i] = sumL[i];\n\t\t\tfor(int i = n - 1;\
    \ i >= 0; i --) {\n\t\t\t\tint v = sa[i];\n\t\t\t\tif(v >= 1 && ls[v - 1]) {\n\
    \t\t\t\t\tsa[-- buf[s[v - 1] + 1]] = v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\n\t\t\
    int[] lmsMap = new int[n + 1];\n\t\tArrays.fill(lmsMap, -1);\n\t\tint m = 0;\n\
    \t\tfor(int i = 1; i < n; i ++) if(!ls[i - 1] && ls[i]) lmsMap[i] = m ++;\n\n\t\
    \tint[] lms = new int[m];\n\t\t{\n\t\t\tint p = 0;\n\t\t\tfor(int i = 1; i < n;\
    \ i++) if(!ls[i - 1] && ls[i]) lms[p ++] = i;\n\t\t}\n\n\t\tinduce.accept(lms);\n\
    \n\t\tif(m > 0) {\n\t\t\tint sortedLms[] = new int[m];\n\t\t\t{\n\t\t\t\tint p\
    \ = 0;\n\t\t\t\tfor(int v : sa) if(lmsMap[v] != -1) sortedLms[p ++] = v;\n\t\t\
    \t}\n\t\t\tint recS[] = new int[m];\n\t\t\tint recUpper = 0;\n\t\t\trecS[lmsMap[sortedLms[0]]]\
    \ = 0;\n\t\t\tfor(int i = 1; i < m; i ++) {\n\t\t\t\tint l = sortedLms[i - 1],\
    \ r = sortedLms[i];\n\t\t\t\tint endL = (lmsMap[l] + 1 < m) ? lms[lmsMap[l] +\
    \ 1] : n;\n\t\t\t\tint endR = (lmsMap[r] + 1 < m) ? lms[lmsMap[r] + 1] : n;\n\t\
    \t\t\tboolean same = true;\n\t\t\t\tif(endL - l != endR - r) same = false;\n\t\
    \t\t\telse {\n\t\t\t\t\twhile(l < endL && s[l] == s[r]) { l++; r++; }\n\t\t\t\t\
    \tif(l == n || s[l] != s[r]) same = false;\n\t\t\t\t}\n\t\t\t\tif(!same) recUpper++;\n\
    \t\t\t\trecS[lmsMap[sortedLms[i]]] = recUpper;\n\t\t\t}\n\n\t\t\tint[] recSA =\
    \ sais(recS, recUpper);\n\n\t\t\tfor(int i = 0; i < m; i ++) sortedLms[i] = lms[recSA[i]];\n\
    \t\t\tinduce.accept(sortedLms);\n\t\t}\n\n\t\treturn sa;\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/SuffixArray.java
  requiredBy:
  - library/LcpArray.java
  timestamp: '2023-03-23 19:02:13+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/SuffixArray_test.java
  - library/LcpArray_test.java
documentation_of: library/SuffixArray.java
layout: document
redirect_from:
- /library/library/SuffixArray.java
- /library/library/SuffixArray.java.html
title: library/SuffixArray.java
---
