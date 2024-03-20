//
//  ScrumsView.swift
//  Scrumdinger
//
//  Created by Yixuan Dai on 20/03/2024.
//

import SwiftUI

struct ScrumsView: View {
    let scrums: [DailyScrum]
    
    var body: some View {
        List(scrums) { scrum in
            CardView(scrum: scrum)
                .listRowBackground(scrum.theme.mainColor)
        }
    }
}
#Preview {
    ScrumsView(scrums: DailyScrum.sampleData)
}
