package com.masashik.app;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TagContentExtractor {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int testCaseNum = Integer.parseInt(scan.nextLine());

		scan.next();

		while (testCaseNum-- > 0) {

			String tag = scan.nextLine();



			/**
			 * Inputs:
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
			 *
			 *
			 * 10
			 * <h1>some</h1>
			 * <h1>had<h1>public</h1></h1>
			 * <h1>had<h1>public</h1515></h1>
			 * <h1><h1></h1></h1>
			 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			 * <<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
			 * <>hello</>
			 * <>hello</><h>dim</h>
			 * <>hello</><h>dim</h>>>>>
			 * ---
			 * some
			 * public
			 * None
			 * None
			 * None
			 * None
			 * None
			 * None
			 * dim
			 * dim
			 *
			 *
			 *
			 *
			 *
			 *
			 */

			String regexForCheckingIfAnyTextBeforeBeginingTagAfterEndingTag = "^<.*>$";
//			String regexForOpeningTag = "<(.*?)>";//<(.*?)>(.+?)</(\1)>
//			String regexForClosingTag = "<(/.*?)>";

			Pattern patternOfCheckingIfAnyTextBeforeBeginingTagAfterEndingTag = Pattern.compile(regexForCheckingIfAnyTextBeforeBeginingTagAfterEndingTag);
//			Pattern patternOfOpeningTag = Pattern.compile(regexForOpeningTag);
//			Pattern patternOfClosingTag = Pattern.compile(regexForClosingTag);

			Matcher matcherOfCheckingIfAnyTextBeforeBeginingTagAfterEndingTag = patternOfCheckingIfAnyTextBeforeBeginingTagAfterEndingTag.matcher(tag);
//			Matcher matcherOfOpeningTag = patternOfOpeningTag.matcher(tag);
//			Matcher matcherOfClosingTag = patternOfClosingTag.matcher(tag);

			if (matcherOfCheckingIfAnyTextBeforeBeginingTagAfterEndingTag.find()) {

				//This is valid HTML tags

					String regex = "<(.*?)>([^<>].+?)</(\\1)>";

  				Pattern p = Pattern.compile(regex);
  				Matcher m = p.matcher(tag);

  				if (!m.find()) {
  					System.out.println("None");
  					continue;
					}

  				m.reset();

  				while (m.find()) {
//  					Pattern tagPattern = Pattern.compile("[(<.*?>)|(</.*?>)]");
//						Matcher tagMatcher = tagPattern.matcher(m.group());
//  					String tagTrimmed = tagMatcher.replaceAll("");
  					System.out.println(m.group().replaceAll("(<.+?>)", ""));
					}
			} else {
				System.out.println("None");
			}
		}
		scan.close();
	}
}
