---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Kmp_test.java
    title: library/Kmp_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nfinal\
    \ class Kmp {\n\t// return all the occurrences of P in S\n\t// O(|S|)\n\tpublic\
    \ static final int[] cal(String s, String p) { return cal(s.toCharArray(), p.toCharArray());\
    \ }\n\tpublic static final int[] cal(char[] s, char[] p) { return cal(SimpleUtil.charToInt(s),\
    \ SimpleUtil.charToInt(p)); }\n\tpublic static final int[] cal(int[] s, int[]\
    \ p) {\n\t\tint sLen = s.length;\n\t\tint pLen = p.length;\n\n\t\tint sIndex =\
    \ 1;\n\t\tint pIndex = 0;\n\n\t\tint skip[] = new int[pLen + 1];\n\t\tArrays.fill(skip,\
    \ 0);\n\t\twhile(sIndex < pLen) {\n\t\t\tif(p[sIndex] == p[pIndex]) {\n\t\t\t\t\
    sIndex ++;\n\t\t\t\tpIndex ++;\n\t\t\t\tskip[sIndex] = pIndex;\n\t\t\t}else if(pIndex\
    \ == 0) {\n\t\t\t\tsIndex ++;\n\t\t\t\tskip[sIndex] = 0;\n\t\t\t}else {\n\t\t\t\
    \tpIndex = skip[pIndex];\n\t\t\t}\n\t\t}\n\n\t\tArrayList<Integer> matchIndex\
    \ = new ArrayList<Integer>();\n\t\tsIndex = 0;\n\t\tpIndex = 0;\n\t\twhile(true)\
    \ {\n\t\t\twhile(sIndex < sLen && pIndex < pLen && s[sIndex] == p[pIndex]) {\n\
    \t\t\t\tsIndex ++;\n\t\t\t\tpIndex ++;\n\t\t\t}\n\t\t\tif(pIndex >= pLen) {\n\t\
    \t\t\tmatchIndex.add(sIndex - pLen);\n\t\t\t\tpIndex = skip[pIndex];\n\t\t\t}else\
    \ if(pIndex == 0) {\n\t\t\t\tsIndex ++;\n\t\t\t}else {\n\t\t\t\tpIndex = skip[pIndex];\n\
    \t\t\t}\n\t\t\tif(sIndex >= sLen) break;\n\t\t}\n\n\t\tint matchIndexList[] =\
    \ new int[matchIndex.size()];\n\t\tfor(int i = 0; i < matchIndex.size(); i ++)\
    \ matchIndexList[i] = matchIndex.get(i);\n\t\treturn matchIndexList;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/Kmp.java
  requiredBy: []
  timestamp: '2022-10-05 16:52:48+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/Kmp_test.java
documentation_of: library/Kmp.java
layout: document
redirect_from:
- /library/library/Kmp.java
- /library/library/Kmp.java.html
title: library/Kmp.java
---
